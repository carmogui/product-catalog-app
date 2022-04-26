package com.personal.productcatalog.config.bean;

import com.personal.productcatalog.action.AbstractAction;
import com.personal.productcatalog.action.product.SaveProductToDatabase;
import com.personal.productcatalog.action.product.SendEmailCreatedAbstract;
import com.personal.productcatalog.model.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigActions {

    @Bean
    public AbstractAction<Product> createProduct() {
        SaveProductToDatabase createProduct = new SaveProductToDatabase();

        createProduct.linkWith(new SendEmailCreatedAbstract());

        return createProduct;
    }
}
