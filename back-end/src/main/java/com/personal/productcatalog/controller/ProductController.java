package com.personal.productcatalog.controller;

import com.personal.productcatalog.dto.ProductDTO;
import com.personal.productcatalog.model.Product;
import com.personal.productcatalog.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductDTO> findAll() {
        List<Product> products = productService.findAll();
        return ProductDTO.toDTO(products);
    }

}
