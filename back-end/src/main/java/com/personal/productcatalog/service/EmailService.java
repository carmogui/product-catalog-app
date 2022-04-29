package com.personal.productcatalog.service;

import com.personal.productcatalog.exception.MailException;
import com.personal.productcatalog.model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void send(Email email) {
        try {
            MimeMessage mail = mailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(mail);

            helper.setTo(email.recipient());
            helper.setSubject(email.subject());
            helper.setText(email.body(), true);

            mailSender.send(mail);
        } catch (MessagingException e) {
            throw new MailException(e);
        }
    }
}
