package com.personal.productcatalog.config.bean;

import com.personal.productcatalog.action.product.ProductAction;
import com.personal.productcatalog.action.product.impl.SaveProductToDatabase;
import com.personal.productcatalog.action.product.impl.SendEmailCreatedProduct;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigActions {

    @Bean
    public ProductAction createProduct() {
        SaveProductToDatabase createProduct = new SaveProductToDatabase();

        createProduct.linkWith(new SendEmailCreatedProduct());

        return createProduct;
    }
}
