
package Utils.EmailSender;

import Model.Message;

public class SendMail {

public void sendMailTLS(Message composeMessage){
        
//                // Recipient's email ID needs to be mentioned.
//        String to = composeMessage.getToTeamMember();
//
//        // Sender's email ID needs to be mentioned
//        String from = "info@jmdev.cba.pl";
//        final String username = "info@ktosdzwonil.com";//change accordingly
//        final String password = "12345";//change accordingly
//
//        // Assuming you are sending email through relay.jangosmtp.net
//        String host = "localhost";
//
//
////        Properties props = new Properties();
////        props.put("mail.smtp.host", host);
////        props.put("mail.smtp.socketFactory.port", "465");
////        props.put("mail.smtp.socketFactory.class",
////                "javax.net.ssl.SSLSocketFactory");
////        props.put("mail.smtp.auth", "true");
////        props.put("mail.smtp.port", "465");
//
//
//        Properties props = new Properties();
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.smtp.host", host);
//        props.put("mail.smtp.port", "587");
//
//
//
//        // Get the Session object.
//        Session session = Session.getInstance(props,
//                new javax.mail.Authenticator() {
//                    protected PasswordAuthentication getPasswordAuthentication() {
//                        return new PasswordAuthentication(username, password);
//                    }
//                });
//
//        try {
//            javax.mail.Message message = new MimeMessage(session);
//            message.setFrom(new InternetAddress(from));
//            message.setRecipients(javax.mail.Message.RecipientType.TO,
//                    InternetAddress.parse(to));
//            message.setSubject(composeMessage.getPrefix() + composeMessage.getCustomer() +
//                    " " + composeMessage.getProducts());
//            message.setContent(
//
//                    "<strong>Zarejestrowano nowa rozmowe: </strong><br>" +
//                    "<h2>DANE KLIENTA:</h2>" + "<br>" +
//                    "Imie i nazwisko: " + composeMessage.getCustomer() + "<br>" +
//                    "Firma: " + composeMessage.getCompany() + "<br>" +
//                    "<br>" +
//                    "Nr tel.: " + composeMessage.getPhone() + "<br>" +
//                    "Email: " + composeMessage.getEmail() + "<br>" +
//
//                    "<h3>W sprawie: </h3>" + composeMessage.getProducts() + "<br>" +
//
//                    "<br><br>" +
//                    "Szczególy zapisane podczas rozmowy: \n" + "<br>" +
//                    composeMessage.getDetails() + "<br>" +
//
//                    "<br><br>" +
//                    "----------------------------------------------<br>" +
//                    "-> Program Ktos dzwonil! v.1.0 <br>" +
//                    "www.jmdev.cba.pl"
//
//            , "text/html");
//
//            // Send message
//            Transport.send(message);
//
//            System.out.println("Sent message successfully....");
//
//        } catch (MessagingException e) {
//            throw new RuntimeException(e);
//        }
//    }



}
}
