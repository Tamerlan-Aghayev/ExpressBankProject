package com.company.controller;

import com.company.entity.Category;
import com.company.entity.Product;

import com.company.entity.Supplier;
import com.company.service.CategoryService;
import com.company.service.ProductService;
import com.company.service.SupplierService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductController.class)
public class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;
    @MockBean
    private CategoryService categoryService;
    @MockBean
    private SupplierService supplierService;
    @InjectMocks
    private ProductController productController;


    @Test
    public void getProducts() throws Exception {

        List<Product> products = new ArrayList<>();

        when(productService.getProducts()).thenReturn(products);

        mockMvc.perform(get("/products"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("success"));
        ;
    }

    @Test
    public void addProduct() throws Exception {
        Product product=getProduct();
        when(productService.addOrUpdateProduct(product)).thenReturn(product);

        mockMvc.perform(post("/product")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "    \"name\":\"fridge\",\n" +
                                "    \"price\":1000,\n" +
                                "    \"description\":\"A device for keeping food cool\",\n" +
                                "    \"categoryDTO\":{\n" +
                                "        \"id\":4,\n" +
                                "    \"name\":\"electronics\"\n" +
                                "},\n" +
                                "    \"supplierDTO\":{\n" +
                                "        \"id\":4,\n" +
                                "    \"name\":\"ElecTech Solutions\",\n" +
                                "    \"address\": \"Evergreen Avenue\"\n" +
                                "}\n" +
                                "}"))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("success"));

    }
    @Test
    public void updateProduct() throws Exception {

        Product product=getProduct();
        when(productService.addOrUpdateProduct(product)).thenReturn(product);
        mockMvc.perform(post("/product")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "    \"id\":1,\n" +
                                "    \"name\":\"fridge\",\n" +
                                "    \"price\":1000,\n" +
                                "    \"description\":\"A device for keeping food cool\",\n" +
                                "    \"categoryDTO\":{\n" +
                                "        \"id\":4,\n" +
                                "    \"name\":\"electronics\"\n" +
                                "},\n" +
                                "    \"supplierDTO\":{\n" +
                                "        \"id\":4,\n" +
                                "    \"name\":\"ElecTech Solutions\",\n" +
                                "    \"address\": \"Evergreen Avenue\"\n" +
                                "}\n" +
                                "}"))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("success"));
    }

    @Test
    public void getById() throws Exception {
        Product product=getProduct();
        when(productService.getProductByID(1)).thenReturn(product);

        mockMvc.perform(get("/product")
                        .contentType(MediaType.APPLICATION_JSON).queryParam("id","1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("success"));

    }
    @Test
    public void deleteById() throws Exception {
        Product product=getProduct();
        when(productService.deleteProduct(1)).thenReturn(product);

        mockMvc.perform(delete("/product")
                        .contentType(MediaType.APPLICATION_JSON).queryParam("id","1"))
                .andExpect(status().isNoContent());

    }


    private Product getProduct(){
        Product product = new Product();

        product.setName("fridge");
        product.setPrice(1000);
        product.setDescription("A device for keeping food cool");

        Category category = new Category();
        category.setId(4);
        category.setName("electronics");
        product.setCategoryByCategoryId(category);

        Supplier supplier = new Supplier();
        supplier.setId(4);
        supplier.setName("ElecTech Solutions");
        supplier.setAddress("Evergreen Avenue");
        product.setSupplierBySupplierId(supplier);
        return product;
    }
}
