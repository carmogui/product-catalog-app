package com.personal.productcatalog.action.product;

import com.personal.productcatalog.action.AbstractAction;
import com.personal.productcatalog.annotations.Action;
import com.personal.productcatalog.model.Email;
import com.personal.productcatalog.model.Product;
import com.personal.productcatalog.model.User;
import com.personal.productcatalog.service.EmailService;
import com.personal.productcatalog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import static com.personal.productcatalog.utils.EmailUtils.readEmailBodyFile;

@Action
public class SendEmailProductCreated extends AbstractAction<Product> {

    private static final String SUBJECT = "O produto foi criado!";
    private static final String BODY = readEmailBodyFile("created-product");

    @Autowired
    private UserService userService;
    @Autowired
    private EmailService emailService;

    @Override
    public Product perform(Product product) {
        User user = userService.getCurrentUser();

        Email email = new Email(user.getEmail(), SUBJECT, getBodyWithParameters(product, user));

        emailService.sendAsync(email);

        return performNext(product);
    }

    private String getBodyWithParameters(Product product, User user) {
        return String.format(BODY, user.getName(), product.getId(), product.getName());
    }
}
