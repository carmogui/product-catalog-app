package com.personal.productcatalog.service;

import com.personal.productcatalog.exception.NotFoundException;
import com.personal.productcatalog.fixture.ProductFixture;
import com.personal.productcatalog.form.ProductForm;
import com.personal.productcatalog.model.Product;
import com.personal.productcatalog.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.only;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    private static final int LIST_SIZE = 5;

    @InjectMocks
    private ProductService productService;
    @Mock
    private ProductRepository productRepository;

    @Test
    public void shouldReturnAllProducts() {
        Pageable page = PageRequest.of(0, 10);

        given(productRepository.findAll(any(), eq(page))).willReturn(ProductFixture.get().buildRandomPage(LIST_SIZE));

        Page<Product> products = productService.findAll(null, page);

        then(productRepository).should(only()).findAll(any(), eq(page));
        assertEquals(LIST_SIZE, products.getTotalElements());
    }

    @Test
    public void shouldReturnProductById() {
        Product product = ProductFixture.get().buildRandom();
        given(productRepository.findById(product.getId())).willReturn(Optional.of(product));

        Product received = productService.findById(product.getId());

        then(productRepository).should(only()).findById(product.getId());
        assertEquals(product, received);
    }

    @Test
    public void shouldThrowExceptionWhenProductNotExistingInRepository() {
        long nonExistentId = 9999999999L;

        given(productRepository.findById(nonExistentId)).willReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> productService.findById(nonExistentId));
        then(productRepository).should(only()).findById(nonExistentId);
    }

    @Test
    public void shouldSaveProductByForm() {
//        Product expectedProduct = ProductFixture.get().buildRandom();
//        ProductForm productForm = getProductFormByProduct(expectedProduct);
//
//        when(productRepository.save(any(Product.class))).thenReturn(expectedProduct);
//
//        Product product = productService.saveByForm(productForm);
//
//        Assertions.assertEquals(expectedProduct.getName(), product.getName());
//        Assertions.assertEquals(expectedProduct.getPrice(), product.getPrice());
//        Assertions.assertEquals(expectedProduct.getStock(), product.getStock());
    }

    private ProductForm getProductFormByProduct(Product expectedProduct) {
        ProductForm productForm = new ProductForm();
        BeanUtils.copyProperties(expectedProduct, productForm);
        return productForm;
    }
}
