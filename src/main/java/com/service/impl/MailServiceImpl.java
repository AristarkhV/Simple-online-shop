package com.service.impl;

import com.model.Code;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import com.service.MailService;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class MailServiceImpl implements MailService {

    private static final Logger logger = Logger.getLogger(MailServiceImpl.class);

    @Override
    public void sendOneTimeCode(Code code, String email) {
        final String username = "simple.online.shop.for.education@gmail.com";
        final String password = "simple.online.shop.for.education+-";

        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(properties,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(email));
            message.setSubject("One-Time Code for buying");
            message.setText("Hi! It's your code " + code.getCode());
            Transport.send(message);
        } catch (MessagingException e) {
            logger.error("You have error with sending one time code", e);
        }
    }

}
