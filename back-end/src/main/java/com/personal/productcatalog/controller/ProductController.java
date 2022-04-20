package com.personal.productcatalog.controller;

import com.personal.productcatalog.dto.ProductDTO;
import com.personal.productcatalog.form.ProductForm;
import com.personal.productcatalog.model.Product;
import com.personal.productcatalog.service.ProductService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

import static com.personal.productcatalog.utils.SecurityUtils.ROLE_ADMIN;
import static com.personal.productcatalog.utils.SecurityUtils.ROLE_USER;

@Api(tags = "Product")
@RestController
@RequestMapping("/product")
@Secured({ROLE_ADMIN, ROLE_USER})
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public Page<ProductDTO> findAll(Pageable pageable) {
        Page<Product> products = productService.findAll(pageable);
        return ProductDTO.toDTO(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable Long id) {
        Product product = productService.findById(id);
        return ResponseEntity.ok(new ProductDTO(product));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<ProductDTO> deleteById(@PathVariable Long id) {
        productService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ProductDTO> saveByForm(@RequestBody @Valid ProductForm form, UriComponentsBuilder uriBuilder) {
        Product product = productService.saveByForm(form);

        URI uri = uriBuilder.path("/product/{id}").buildAndExpand(product.getId()).toUri();
        return ResponseEntity.created(uri).body(new ProductDTO(product));
    }
}
