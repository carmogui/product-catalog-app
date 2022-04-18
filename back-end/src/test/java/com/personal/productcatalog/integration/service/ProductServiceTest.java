package com.personal.productcatalog.integration.service;

import com.personal.productcatalog.fixture.ProductFixture;
import com.personal.productcatalog.form.ProductForm;
import com.personal.productcatalog.model.Product;
import com.personal.productcatalog.repository.ProductRepository;
import com.personal.productcatalog.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService productService;
    @MockBean
    private ProductRepository productRepository;

    @Test
    public void shouldReturnAllProducts() {
        int expectedSize = 5;

        when(productRepository.findAll()).thenReturn(ProductFixture.get().buildRandomList(expectedSize));

        List<Product> products = productService.findAll();

        Assertions.assertEquals(expectedSize, products.size());
    }

    @Test
    public void shouldReturnProductById() {
        Product expectedProduct = ProductFixture.get().buildRandom();

        when(productRepository.findById(expectedProduct.getId())).thenReturn(Optional.of(expectedProduct));

        Product product = productService.findById(expectedProduct.getId());

        Assertions.assertEquals(expectedProduct, product);
    }

    @Test
    public void shouldSaveProductByForm() {
        Product expectedProduct = ProductFixture.get().buildRandom();
        ProductForm productForm = getProductFormByProduct(expectedProduct);

        when(productRepository.save(any(Product.class))).thenReturn(expectedProduct);

        Product product = productService.saveByForm(productForm);

        Assertions.assertEquals(expectedProduct.getName(), product.getName());
        Assertions.assertEquals(expectedProduct.getPrice(), product.getPrice());
        Assertions.assertEquals(expectedProduct.getStock(), product.getStock());
    }

    private ProductForm getProductFormByProduct(Product expectedProduct) {
        ProductForm productForm = new ProductForm();
        BeanUtils.copyProperties(expectedProduct, productForm);
        return productForm;
    }
}
