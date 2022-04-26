package com.personal.productcatalog.action.product;

import com.personal.productcatalog.action.AbstractAction;
import com.personal.productcatalog.annotations.Action;
import com.personal.productcatalog.model.Product;
import com.personal.productcatalog.model.User;
import com.personal.productcatalog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Action
public class SendEmailProductCreated extends AbstractAction<Product> {

    @Autowired
    private UserService userService;
    @Autowired
    private JavaMailSender mailSender;

    @Override
    public Product perform(Product product) {
        User currentUser = userService.getCurrentUser();

        try {
            MimeMessage mail = mailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(mail);
            helper.setTo(currentUser.getEmail());
            helper.setSubject("A product has been created");

            String message = createMessage(product, currentUser);
            helper.setText(message, true);

            mailSender.send(mail);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

        return performNext(product);
    }

    private String createMessage(Product product, User user) {
        return String.format("<p>" +
                "Olá %s, o produto [%d]-[%s] foi criado com sucesso" +
                "</p>", user.getName(), product.getId(), product.getName());
    }
}
