package com.personal.productcatalog.action.product;

import com.personal.productcatalog.action.AbstractAction;
import com.personal.productcatalog.annotations.Action;
import com.personal.productcatalog.model.Product;

@Action
public class SendEmailCreatedAbstract extends AbstractAction<Product> {

    @Override
    public Product perform(Product product) {
        System.out.println("************************");
        System.out.println("Email sent");
        System.out.println("************************");
        return performNext(product);
    }
}
