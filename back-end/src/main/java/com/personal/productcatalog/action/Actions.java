package com.personal.productcatalog.action;

import com.personal.productcatalog.action.product.ProductAction;
import com.personal.productcatalog.form.ProductForm;
import com.personal.productcatalog.model.Product;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class Actions {
    private final ProductAction createProduct;

    @Autowired
    public Actions(@Qualifier("createProduct") ProductAction createProduct) {
        this.createProduct = createProduct;
    }

    @Transactional(rollbackOn = Exception.class)
    public Product createProduct(ProductForm form) {
        Product product = new Product();
        BeanUtils.copyProperties(form, product);

        return createProduct.perform(product);
    }
}
