package com.company.dto;

import com.company.annotation.FixedSize;
import com.company.annotation.NotNullOrBlank;
import com.company.entity.Category;



import jakarta.validation.constraints.Size;
public class CategoryDTO {
    private long id;

    @FixedSize(min = 3, max = 50)
    @NotNullOrBlank
    private String name;
    public CategoryDTO(){}
    public CategoryDTO(Category category) {
        this.id = category.getId();
        this.name = category.getName();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
