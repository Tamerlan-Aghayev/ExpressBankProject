package com.company.repository;

import com.company.entity.Category;
import com.company.entity.Supplier;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CategoryRepositoryTest {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private TestEntityManager entityManager;
    @BeforeEach
    void setup() {
        Category category=new Category(1L, "electronics");
        entityManager.merge(category);

    }
    @Test
    public void saveAndFlush(){
        Category category=categoryRepository.saveAndFlush(new Category(2l, "electronics"));
        Assertions.assertNotNull(category);
    }
    @Test
    public void findAll(){
        List<Category> categories=categoryRepository.findAll();
        Assertions.assertEquals(1, categories.size());
    }
}
