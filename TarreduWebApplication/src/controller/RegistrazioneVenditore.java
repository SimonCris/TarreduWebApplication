package controller;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;

import model.Utente;
import model.Venditore;
import persistenceDAO.DAOFactory;

public class RegistrazioneVenditore extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String nome = req.getParameter("nomeVenditore");
		String cognome = req.getParameter("cognomeVenditore");
		String nomeNegozio = req.getParameter("nomeNegozio");
		String email = req.getParameter("emailVenditore");
		String indirizzo = req.getParameter("indirizzoVenditore");
		String numeroDiTelefono = req.getParameter("numeroDiTelefonoVenditore");
		String descrizioneVenditore = req.getParameter("descrizioneVenditore");
		String password = req.getParameter("pswVenditore");
		String confirmPassword = req.getParameter("psw-repeat-Venditore");

		Venditore v = new Venditore();
		v.setNomeTitolare(nome);
		v.setCognomeTitolare(cognome);
		v.setNomeNegozio(nomeNegozio);
		v.setEmailVenditore(email);
		v.setIndirizzoVenditore(indirizzo);
		v.setNumeroTelefonicoVenditore(numeroDiTelefono);
		v.setDescrizioneVenditore(descrizioneVenditore);
		v.setPasswordVenditore(password);

		String latLongs[] = null;
		try {
			latLongs = getLatLongPositions(indirizzo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		v.setLatitudineVenditore(latLongs[0]);
		v.setLongitudineVenditore(latLongs[1]);

		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		factory.getVenditoreDAO().save(v);

		v.stampaVenditore();

		req.setAttribute("venditore", v);

		StringBuilder messaggio = new StringBuilder();
		messaggio.append("Gentile, " + v.getNomeTitolare() + " " + v.getCognomeTitolare() + ",\n");
		messaggio.append("la informiamo che la registrazione è stata effettuata con successo.\n\n");
		messaggio.append("Di seguito le credenziali di registrazione: \n");
		messaggio.append("Indirizzo email : " + v.getEmailVenditore() + "\n");
		messaggio.append("Password : " + v.getPasswordVenditore() + "\n");

		sendEmail(v.getEmailVenditore(), "Conferma registrazione", messaggio.toString());

		RequestDispatcher dispacher = req.getRequestDispatcher("profiloVenditore.jsp");
		dispacher.forward(req, resp);
	}

	public String[] getLatLongPositions(String address) throws Exception {
		int responseCode = 0;
		String api = "https://maps.googleapis.com/maps/api/geocode/xml?address=" + URLEncoder.encode(address, "UTF-8")
				+ "&key=AIzaSyAUvzMYr08iaxtaGH2K31C7lLifLHRL2g4";

		URL url = new URL(api);
		HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
		httpConnection.connect();
		responseCode = httpConnection.getResponseCode();
		if (responseCode == 200) {
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			;
			Document document = builder.parse(httpConnection.getInputStream());
			XPathFactory xPathfactory = XPathFactory.newInstance();
			XPath xpath = xPathfactory.newXPath();
			XPathExpression expr = xpath.compile("/GeocodeResponse/status");
			String status = (String) expr.evaluate(document, XPathConstants.STRING);
			if (status.equals("OK")) {
				expr = xpath.compile("//geometry/location/lat");
				String latitude = (String) expr.evaluate(document, XPathConstants.STRING);
				expr = xpath.compile("//geometry/location/lng");
				String longitude = (String) expr.evaluate(document, XPathConstants.STRING);
				return new String[] { latitude, longitude };
			} else {
				throw new Exception("Error from the API - response status: " + status);
			}
		}
		return null;
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

}
