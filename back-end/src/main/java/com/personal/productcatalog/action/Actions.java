package com.personal.productcatalog.action;

import com.personal.productcatalog.action.product.CreateProduct;
import com.personal.productcatalog.action.product.CreateProductAction;
import com.personal.productcatalog.exception.InternalServerErrorException;
import com.personal.productcatalog.form.ProductForm;
import com.personal.productcatalog.model.Product;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

import static com.personal.productcatalog.utils.ActionUtils.updateToChainOfResponsibility;

@Component
public class Actions {

    private final List<CreateProduct> createProductActions;

    @Autowired
    public Actions(List<CreateProduct> createProductActions) {
        this.createProductActions = createProductActions;

        updateToChainOfResponsibility(createProductActions.iterator(), (c1, c2) -> c1.linkWith((CreateProductAction) c2));
    }

    @Transactional(rollbackOn = Exception.class)
    public Product createProduct(ProductForm form) {
        Product product = new Product();
        BeanUtils.copyProperties(form, product);

        CreateProduct createProduct = createProductActions.stream()
                .findFirst()
                .orElseThrow(() -> new InternalServerErrorException("Spring dependency injection error, list is empty/null"));

        return createProduct.perform(product);
    }
}
