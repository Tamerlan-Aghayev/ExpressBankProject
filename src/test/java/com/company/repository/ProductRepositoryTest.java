package com.company.repository;

import com.company.entity.Category;
import com.company.entity.Product;
import com.company.entity.Supplier;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource(properties = {
        "spring.datasource.url=jdbc:postgresql://localhost:5432/postgres?currentSchema=express_bank_test",
        "spring.datasource.username=postgres",
        "spring.datasource.password=postgres"
})
public class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setup() {
        Supplier supplier=new Supplier(1L, "ElecTech", "Baku");
        entityManager.merge(supplier);
        Category category=new Category(1L, "electronics");
        entityManager.merge(category);
        Product product=new Product();
        product.setId(1L);
        product.setName("fridge");
        product.setPrice(1000);
        product.setDescription("for cooling");
        product.setCategoryByCategoryId(category);
        product.setSupplierBySupplierId(supplier);
        entityManager.merge(product);
    }
    @Test
    public void saveAndFlush(){
        Supplier supplier=new Supplier(1, "ElecTech", "Baku");
        entityManager.merge(supplier);
        Category category=new Category(1, "electronics");
        entityManager.merge(category);
        Product product=new Product();
        product.setId(1);
        product.setName("fridge");
        product.setPrice(1000);
        product.setDescription("for cooling");
        product.setCategoryByCategoryId(category);
        product.setSupplierBySupplierId(supplier);
        Product addedProduct=productRepository.saveAndFlush(product);
        Assertions.assertNotNull(addedProduct);
    }
    @Test
    public void findAll(){
        List<Product> products=productRepository.findAll();
        Assertions.assertEquals(1, products.size());
    }
    @Test
    public void getByID(){
        Assertions.assertNotNull(productRepository.getReferenceById((long)1));
    }
    @Test
    public void deleteByID(){
        productRepository.deleteById((long)1);
        Assertions.assertNull(productRepository.findById((long)1).orElse(null));
    }
}
