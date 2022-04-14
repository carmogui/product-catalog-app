package com.personal.productcatalog.dto;

import com.personal.productcatalog.model.Product;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ProductDTO {

    private final Long id;
    private final String name;
    private final Integer stock;
    private final BigDecimal price;

    public ProductDTO(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.stock = product.getStock();
        this.price = product.getPrice();
    }

    public static List<ProductDTO> toDTO(List<Product> products) {
        return products.stream()
                .map(ProductDTO::new)
                .collect(Collectors.toList());
    }
}
