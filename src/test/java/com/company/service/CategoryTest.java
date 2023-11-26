package com.company.service;

import com.company.entity.Category;
import com.company.repository.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.web.bind.MethodArgumentNotValidException;




public class CategoryTest {
    @Mock
    private CategoryRepository categoryRepository;
    @InjectMocks
    private  CategoryService categoryService;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void addCategory() throws MethodArgumentNotValidException {
        Category category=new Category();
        category.setName("food");
        categoryService.addCategory(category);
        Mockito.verify(categoryRepository, Mockito.atLeastOnce()).saveAndFlush(category);
    }
    @Test
    public void getCategories()  {

        categoryService.getAllCategories();
        Mockito.verify(categoryRepository, Mockito.atLeastOnce()).findAll();
    }
    @Test
    public void getCategoryByID()  {

        categoryService.getById(5);
        Mockito.verify(categoryRepository, Mockito.atLeastOnce()).getReferenceById((long)5);
    }

}


