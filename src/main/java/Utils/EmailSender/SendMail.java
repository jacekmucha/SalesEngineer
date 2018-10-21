
package Utils.EmailSender;

import Model.EmailServerSettings;
import Model.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendMail{

    final String importantStatus = "Bardzo ważne!";
    final String delayStatus = "Opóźnienie!";
    final String introText = "Dzwonił ";
    final String introTextCase = " w sprawie ";


    private String setMessagePrefix(Message message) {
        StringBuilder stringBuilder = new StringBuilder();
        if (message.isStatusImportant()) {
            stringBuilder.append(importantStatus).append(" ");
        }
        if (message.isStatusIsDelay()) {
            stringBuilder.append(delayStatus).append(" ");
        }
        return stringBuilder.toString();
    }



    public void send(Message message, EmailServerSettings settings) {
        if (settings.getConnectionType().equals("TLS")){
            sendMailTLS(message, settings);
        } else sendMailSSL(message, settings);
    }

    public void sendMailTLS(Message composeMessage, EmailServerSettings settings) {

        String to = composeMessage.getSendTo();
        String from = settings.getFrom();
        final String username = settings.getEmailUsername();
        final String password = settings.getEmailPassword();
        String host = settings.getHOST_TLS();
        String port = settings.getPORT_TLS();

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            javax.mail.Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(javax.mail.Message.RecipientType.TO,
                    InternetAddress.parse(to));
            message.setSubject(setMessagePrefix(composeMessage) + introText + composeMessage.getCustomerName() +
                    introTextCase + composeMessage.getProducts());
            message.setContent(

                    "<strong>Zarejestrowano nowa rozmowe: </strong><br>" +
                            "<h2>DANE KLIENTA:</h2>" + "<br>" +
                            "Imie i nazwisko: " + composeMessage.getCustomerName() + "<br>" +
                            "Firma: " + composeMessage.getCustomerCompany() + "<br>" +
                            "<br>" +
                            "Nr tel.: " + composeMessage.getCustomerPhone() + "<br>" +
                            "Email: " + composeMessage.getCustomerEmail() + "<br>" +

                            "<h3>W sprawie: </h3>" + composeMessage.getProducts() + "<br>" +

                            "<br><br>" +
                            "Szczególy zapisane podczas rozmowy: \n" + "<br>" +
                            composeMessage.getDetails() + "<br>" +

                            "<br><br>" +
                            "Powiadomienie wysłane do: \n" +
                            composeMessage.getSendTo() + "\n" +
                            "----------------------------------------------<br>" +
                            "SalesEngineer" +
                            "www.jmdev.cba.pl"

                    , "text/html");
            Transport.send(message);

            System.out.println("Sent message successfully....");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendMailSSL(Message message, EmailServerSettings settings) {
        //        Properties props = new Properties();
        //        props.put("mail.smtp.host", host);
        //        props.put("mail.smtp.socketFactory.port", "465");
        //        props.put("mail.smtp.socketFactory.class",
        //                "javax.net.ssl.SSLSocketFactory");
        //        props.put("mail.smtp.auth", "true");
        //        props.put("mail.smtp.port", "465");
    }

}
