package com.company.service;

import com.company.entity.Product;
import com.company.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.web.bind.MethodArgumentNotValidException;

public class ProductTest {
    @Mock
    private ProductRepository productRepository;
    @InjectMocks
    private  ProductService productService;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void addProduct()throws MethodArgumentNotValidException {
        Product product=new Product();
        productService.addOrUpdateProduct(product);
        Mockito.verify(productRepository, Mockito.atLeastOnce()).saveAndFlush(product);

    }
    @Test
    public void getProducts() {
        productService.getProducts();
        Mockito.verify(productRepository, Mockito.atLeastOnce()).findAll();
    }
    @Test
    public void getProduct() {
        productService.getProductByID((long)5);
        Mockito.verify(productRepository, Mockito.atLeastOnce()).getReferenceById((long)5);
    }
    @Test
    public void deleteProduct() {
        productService.deleteProduct((5));
        Mockito.verify(productRepository, Mockito.atLeastOnce()).deleteById((long)5);
    }
}
