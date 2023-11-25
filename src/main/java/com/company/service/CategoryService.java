package com.company.service;

import com.company.entity.Category;
import com.company.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;

@Service

public class CategoryService {
    private CategoryRepository categoryRepository;
    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    public void addCategory( Category category) throws DataAccessException, MethodArgumentNotValidException {

        categoryRepository.saveAndFlush(category);
    }
    public List<Category> getAllCategories() throws DataAccessException {
        return categoryRepository.findAll();
    }
    public Category getById(long id) throws DataAccessException{
        return categoryRepository.getReferenceById(id);
    }
}
