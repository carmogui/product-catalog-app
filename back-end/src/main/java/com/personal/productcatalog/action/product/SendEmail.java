package com.personal.productcatalog.action.product;

import com.personal.productcatalog.annotations.Action;
import com.personal.productcatalog.model.Product;

@Action
public class SendEmail extends CreateProductAction {

    @Override
    public Product perform(Product product) {
        System.out.println("************************");
        System.out.println("Email sent");
        System.out.println("************************");
        return performNext(product);
    }
}
