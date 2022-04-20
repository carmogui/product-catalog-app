package com.personal.productcatalog.service;

import com.personal.productcatalog.exception.NotFoundException;
import com.personal.productcatalog.form.ProductForm;
import com.personal.productcatalog.model.Product;
import com.personal.productcatalog.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Page<Product> findAll(Pageable pageable){
        return productRepository.findAll(pageable);
    }

    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Not found product with id " + id));
    }

    public void deleteById(Long id) {
        Product product = findById(id);
        productRepository.delete(product);
    }

    public Product saveByForm(ProductForm form) {
        Product product = new Product();
        BeanUtils.copyProperties(form, product);

        return productRepository.save(product);
    }
}
