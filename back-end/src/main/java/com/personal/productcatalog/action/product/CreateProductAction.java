package com.personal.productcatalog.action.product;

import com.personal.productcatalog.model.Product;

import static java.util.Objects.isNull;

public abstract class CreateProductAction implements CreateProduct {

    private CreateProductAction next;

    @Override
    public void linkWith(CreateProductAction next) {
        this.next = next;
    }

    protected Product performNext(Product product) {
        return isNull(next) ? product : next.perform(product);
    }
}
