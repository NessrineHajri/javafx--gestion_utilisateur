package tn.esprit.API;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailAPI {

    public static void sendEmailVerification(String recipientEmail) {

        final String username = "hjness66@gmail.com"; // Votre adresse Gmail
        final String password = "cedz bgkg qgkl iudo"; // Votre mot de passe Gmail

        // Propriétés pour la configuration SMTP de Gmail
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        // Création d'une session d'authentification
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Création du message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            message.setSubject("Email Verification");

            message.setContent("<h1>Hi! Please confirm your email!</h1>" +
                            "<p>Please confirm your email address by clicking the following link:  <a href='http://yourserver:yourport/yourwebapp/welcome'> confirm my Email</a></p>",
                    "text/html");

            // Envoi du message
            Transport.send(message);

            System.out.println("Email sent successfully.");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        // Exemple d'appel à la méthode sendEmailVerification
        sendEmailVerification("recipient@example.com");
    }

}