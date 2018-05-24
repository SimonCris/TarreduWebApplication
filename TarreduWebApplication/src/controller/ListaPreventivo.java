package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Preventivo;
import model.ProdottoConImmagini;
import persistenceDAO.DAOFactory;
import persistenceDAO.ProdottoDAO;

/**
 * Questa servlet riceve una lista di prodotti selezionati dall'utente all'interno
 * del carrello, reperisce i vari venditori ed invia loro le richieste di preventivo
 * tramite javamail.
 */


public class ListaPreventivo extends HttpServlet {

	private String emailUtente;
	private String credenzialiUtente;
	private ArrayList<ProdottoConImmagini> prodottiDaInserireNelPreventivo;
	private HashSet<String> listaVenditori;

	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		setEmailUtente((String) req.getSession().getAttribute("emailUtenteLoggato"));

		setCredenzialiUtente((String) (req.getSession().getAttribute("nomeUtente") + " "
				+ req.getSession().getAttribute("cognomeUtente")));

		String[] prodotti = req.getParameterValues("prodotti[]");
		String[] richieste = req.getParameterValues("richieste[]");

		prodottiDaInserireNelPreventivo = new ArrayList<ProdottoConImmagini>();

		listaVenditori = new HashSet<String>();

		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ProdottoDAO prodottoDao = factory.getProdottoDAO();

		for (int i = 0; i < prodotti.length; i++) {

			ProdottoConImmagini prodotto = prodottoDao.getProdottoPerPreventivo(Integer.parseInt(prodotti[i]));

			prodotto.setRichiestaAggiuntivaInPreventivo(richieste[i]);

			prodottiDaInserireNelPreventivo.add(prodotto);

			listaVenditori.add(prodotto.getEmailVenditore());

		}

		HashMap<String, List<ProdottoConImmagini>> venditoriEProdotti = new HashMap<String, List<ProdottoConImmagini>>();

		for (String venditori : listaVenditori) {

			List<ProdottoConImmagini> lista = new ArrayList<>();
			venditoriEProdotti.put(venditori, lista);

		}




		for (ProdottoConImmagini prodotto : prodottiDaInserireNelPreventivo) {

			venditoriEProdotti.get(prodotto.getEmailVenditore()).add(prodotto);

		}

		// Inizia a creare il messaggio di notifica per il cliente
		StringBuilder messaggioUtente = new StringBuilder();

		messaggioUtente.append("Gentile " + credenzialiUtente + ",\n");
		messaggioUtente.append(
				"le inviamo una copia delle richieste di preventivo mandate attraverso il nostro sito ai/al venditori/e: \n");

		messaggioUtente.append("------------------\n\n");

		for (String venditore : listaVenditori) {

			String mess = buildMessage(venditoriEProdotti, venditore);
			sendEmail(venditore, "Richiesta di preventivo", mess);

			messaggioUtente.append(mess);

		}

		messaggioUtente.append("------------------\n\n");
		sendEmail(emailUtente, "Conferma invio richieste di preventivo", messaggioUtente.toString());


	
	inserisciPreventivoInDB();
	rimuoviProdottiDalCarrello();

	}

	public void sendEmail(String destinatario, String oggetto, String messaggio) {
		final String username = "tarredu.arredamenti@gmail.com";
		final String password = "Cacazza01!";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("tarredu.arredamenti@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
			message.setSubject(oggetto);
			message.setText(messaggio);

			Transport.send(message);

	

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	public String buildMessage(HashMap<String, List<ProdottoConImmagini>> prodottiVenditore, String emailVenditore) {

		String nomeVenditore = prodottiVenditore.get(emailVenditore).get(0).getNomeNegozioVenditore();

		StringBuilder builder = new StringBuilder();
		builder.append("Salve, " + nomeVenditore + ",\n");
		builder.append("la contattiamo a nome di " + getCredenzialiUtente()
				+ " per sottoporle una richiesta di preventivo effettuata dal nostro sito Tarredu Arredamenti. \n");
		builder.append("Il preventivo contiene i seguenti articoli: \n\n");

		for (ProdottoConImmagini prodotto : prodottiVenditore.get(emailVenditore)) {

			builder.append("ARTICOLO\n");
			builder.append("Id -> " + prodotto.getIdProdotto() + ".\n");
			builder.append("Nome -> " + prodotto.getNomeProdotto() + ".\n");

			if (!(prodotto.getRichiestaAggiuntivaInPreventivo().equals(""))) {
				builder.append("Richiesta aggiuntiva del cliente sull'articolo in questione -> "
						+ prodotto.getRichiestaAggiuntivaInPreventivo() + ".\n");
			} else {
				builder.append("Richiesta aggiuntiva del cliente sull'articolo in questione -> Nessuna. \n");
			}

			builder.append("---------------------\n");

		}

		builder.append(
				"La preghiamo di rispondere con tutte le informazioni richieste dal cliente per i precedenti prodotti.\n");
		builder.append("Contattare il cliente al seguente indirizzo di posta elettronica: " + emailUtente + ".\n\n");
		builder.append("Distinti saluti.\n");
		builder.append("Staff di Tarredu Arredamenti.\n");

		return builder.toString();

	}

	public void inserisciPreventivoInDB() {
		Preventivo p = new Preventivo();
		p.setUtente(emailUtente);
		p.setListaProdotti(prodottiDaInserireNelPreventivo);
		p.setListaVenditori(listaVenditori);
	

		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		factory.getPreventivoDAO().save(p);

	}

	public void rimuoviProdottiDalCarrello() {

		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		factory.getCarrelloDAO().rimuoviProdotti(prodottiDaInserireNelPreventivo, emailUtente);

	}

	public String getEmailUtente() {
		return emailUtente;
	}

	public void setEmailUtente(String emailUtente) {
		this.emailUtente = emailUtente;
	}

	public String getCredenzialiUtente() {
		return credenzialiUtente;
	}

	public void setCredenzialiUtente(String credenzialiUtente) {
		this.credenzialiUtente = credenzialiUtente;
	}

}
