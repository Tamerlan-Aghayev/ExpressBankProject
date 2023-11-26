package com.company.dto;

import com.company.annotation.*;
import com.company.entity.Product;

public class ProductDTO {
    private long id;
    @FixedSize(min=3, max=50)
    @NotNullOrBlank
    private String name;
    @PositivePrice
    private double price;
    @MaxSize
    private String description;
    @Exists
    private CategoryDTO categoryDTO;
    @Exists
    private SupplierDTO supplierDTO;
    public ProductDTO(){}
    public ProductDTO(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
        this.description = product.getDescription();
        this.categoryDTO=new CategoryDTO(product.getCategoryByCategoryId());
        this.supplierDTO=new SupplierDTO(product.getSupplierBySupplierId());
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CategoryDTO getCategoryDTO() {
        return categoryDTO;
    }

    public void setCategoryDTO(CategoryDTO categoryDTO) {
        this.categoryDTO = categoryDTO;
    }

    public SupplierDTO getSupplierDTO() {
        return supplierDTO;
    }

    public void setSupplierDTO(SupplierDTO supplierDTO) {
        this.supplierDTO = supplierDTO;
    }
}
