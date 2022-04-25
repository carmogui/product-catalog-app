package com.personal.productcatalog.action.product.impl;

import com.personal.productcatalog.action.product.ProductAction;
import com.personal.productcatalog.annotations.Action;
import com.personal.productcatalog.model.Product;
import com.personal.productcatalog.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

@Action
public class SaveProductToDatabase extends ProductAction {

    @SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
    @Autowired
    private ProductService productService;

    @Override
    public Product perform(Product product) {
        Product savedProduct = productService.save(product);

        return performNext(savedProduct);
    }
}
