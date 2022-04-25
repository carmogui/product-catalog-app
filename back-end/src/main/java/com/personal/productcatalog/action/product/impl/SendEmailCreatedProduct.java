package com.personal.productcatalog.action.product.impl;

import com.personal.productcatalog.action.product.ProductAction;
import com.personal.productcatalog.annotations.Action;
import com.personal.productcatalog.model.Product;

@Action
public class SendEmailCreatedProduct extends ProductAction {

    @Override
    public Product perform(Product product) {
        System.out.println("************************");
        System.out.println("Email sent");
        System.out.println("************************");
        return performNext(product);
    }
}
