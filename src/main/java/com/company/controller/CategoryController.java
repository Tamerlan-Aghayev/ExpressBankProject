package com.company.controller;

import com.company.dto.CategoryDTO;
import com.company.dto.ResponseDTO;
import com.company.entity.Category;
import com.company.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/category")
    public ResponseEntity<ResponseDTO> addCategory(@RequestBody @Valid CategoryDTO dto) {
        try {
            Category category = new Category();
            category.setName(dto.getName());
            categoryService.addCategory(category);
            return ResponseEntity.status(HttpStatus.CREATED).body(ResponseDTO.of(dto, "success"));
        } catch (MethodArgumentNotValidException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseDTO.of("Validation failed"));
        } catch (DataAccessException ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ResponseDTO.of("Error while adding category"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseDTO.of("Bad Request"));
        }
    }

    @GetMapping("/categories")
    public ResponseEntity<ResponseDTO> getAllCategories() {
        try {
            List<Category> categories = categoryService.getAllCategories();
            List<CategoryDTO> categoryDTOS = new ArrayList<>();
            for (Category category : categories) {
                categoryDTOS.add(new CategoryDTO(category));
            }
            return ResponseEntity.status(HttpStatus.OK).body(ResponseDTO.of(categoryDTOS, "success"));
        } catch (DataAccessException ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ResponseDTO.of("Error while getting categories"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseDTO.of("Bad Request"));
        }
    }
}
