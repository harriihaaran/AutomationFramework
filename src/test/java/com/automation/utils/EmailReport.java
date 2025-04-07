package com.automation.utils;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailReport {
    public static void sendReport() {
        final String username = ConfigReader.getProperty("email.username");
        final String password = ConfigReader.getProperty("email.password");
        String toEmail = ConfigReader.getProperty("email.recipient");

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject("Automation Test Report");

            // Email Body
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText("Please find the attached test report.");

            // Attach the Extent Report
            MimeBodyPart attachmentPart = new MimeBodyPart();
            attachmentPart.attachFile("test-output/ExtentReport.html");

            // Combine Parts
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            multipart.addBodyPart(attachmentPart);

            message.setContent(multipart);

            Transport.send(message);
            System.out.println("Test report sent successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
