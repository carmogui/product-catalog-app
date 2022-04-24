package com.personal.productcatalog.action.product;

import com.personal.productcatalog.model.Product;

public interface CreateProduct {

    void linkWith(CreateProductAction next);

    Product perform(Product product);
}
