package com.personal.productcatalog.action.product;

import com.personal.productcatalog.annotations.Action;
import com.personal.productcatalog.model.Product;
import com.personal.productcatalog.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

@Action
public class SaveInDatabase extends CreateProductAction {

    @SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
    @Autowired
    private ProductService productService;

    @Override
    public Product perform(Product product) {
        Product savedProduct = productService.save(product);

        return performNext(savedProduct);
    }
}
