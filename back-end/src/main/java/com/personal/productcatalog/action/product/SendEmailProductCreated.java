package com.personal.productcatalog.action.product;

import com.personal.productcatalog.action.AbstractAction;
import com.personal.productcatalog.annotations.Action;
import com.personal.productcatalog.model.Product;
import com.personal.productcatalog.model.User;
import com.personal.productcatalog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

@Action
public class SendEmailProductCreated extends AbstractAction<Product> {

    @Autowired
    private UserService userService;

    @Override
    public Product perform(Product product) {
        User currentUser = userService.getCurrentUser();
        return performNext(product);
    }
}
