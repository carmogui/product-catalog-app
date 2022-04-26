package com.personal.productcatalog.action.product;

import com.personal.productcatalog.model.Product;

import static java.util.Objects.isNull;

public abstract class ProductAction {

    private ProductAction next;

    public ProductAction linkWith(ProductAction next) {
        this.next = next;
        return next;
    }

    public abstract Product perform(Product product);

    protected Product performNext(Product product) {
        return isNull(next) ? product : next.perform(product);
    }
}
