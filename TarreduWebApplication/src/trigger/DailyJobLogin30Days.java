package trigger;

import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import persistenceDAO.DAOFactory;

public class DailyJobLogin30Days implements Runnable {

	@Override
	public void run() {
		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		List<String> emails = factory.getUtenteDAO().utentiCheNonSiLogganoDa30Giorni();
		String oggetto = "Non Sappiamo Stare Senza di Te!";
		String testo = "Caro utente,\n abbiamo notato che il suo ultimo accesso risale a più "
				+ "di 30 giorni fa, perchè non torni a trovarci? Ti aspettiamo su www.tarredu.it  !";

		for (String emailUtente : emails) {
			sendEmail(emailUtente, oggetto, testo);

		}

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
