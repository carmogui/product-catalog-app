package com.personal.productcatalog.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Setter
@Getter
public class ProductForm {

    @NotNull
    @NotEmpty
    private String name;
    @NotNull
    private Integer stock;
    @NotNull
    private BigDecimal price;
}
