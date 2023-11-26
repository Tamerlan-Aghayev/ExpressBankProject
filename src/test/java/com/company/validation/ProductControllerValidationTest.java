package com.company.validation;

import com.company.controller.ProductController;
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
public class ProductControllerValidationTest {
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
    public void addProductNoName() throws Exception {


        mockMvc.perform(post("/product")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "    \"name\":\"\",\n" +
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
                .andExpect(status().isBadRequest());

    }
    @Test
    public void updateProductNoName() throws Exception {


        mockMvc.perform(post("/product")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "    \"id\":1,\n" +
                                "    \"name\":\"\",\n" +
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
                .andExpect(status().isBadRequest());
    }
    @Test
    public void addProductShortName() throws Exception {


        mockMvc.perform(post("/product")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "    \"name\":\"a\",\n" +
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
                .andExpect(status().isBadRequest());

    }
    @Test
    public void updateProductShortName() throws Exception {


        mockMvc.perform(post("/product")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "    \"id\":1,\n" +
                                "    \"name\":\"a\",\n" +
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
                .andExpect(status().isBadRequest());
    }


    @Test
    public void addProductNegativePrice() throws Exception {


        mockMvc.perform(post("/product")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "    \"name\":\"fridge\",\n" +
                                "    \"price\":-1000,\n" +
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
                .andExpect(status().isBadRequest());

    }
    @Test
    public void updateProductNegativePrice() throws Exception {


        mockMvc.perform(post("/product")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "    \"id\":1,\n" +
                                "    \"name\":\"fridge\",\n" +
                                "    \"price\":-1000,\n" +
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
                .andExpect(status().isBadRequest());

    }


    @Test
    public void addProductLongDescription() throws Exception {


        mockMvc.perform(post("/product")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "    \"name\":\"fridge\",\n" +
                                "    \"price\":-1000,\n" +
                                "    \"description\":\"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum\",\n" +
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
                .andExpect(status().isBadRequest());


    }
    @Test
    public void updateProductLongDescription() throws Exception {


        mockMvc.perform(post("/product")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "    \"id\":1,\n" +
                                "    \"name\":\"fridge\",\n" +
                                "    \"price\":1000,\n" +
                                "    \"description\":\"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum\",\n" +
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
                .andExpect(status().isBadRequest());

    }
    @Test
    public void addProductNoCategory() throws Exception {


        mockMvc.perform(post("/product")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "    \"name\":\"\",\n" +
                                "    \"price\":-1000,\n" +
                                "    \"description\":\"A device for keeping food cool\",\n" +
                                "    \"supplierDTO\":{\n" +
                                "        \"id\":4,\n" +
                                "    \"name\":\"ElecTech Solutions\",\n" +
                                "    \"address\": \"Evergreen Avenue\"\n" +
                                "}\n" +
                                "}"))
                .andExpect(status().isBadRequest());


    }
    @Test
    public void updateProductNoCategory() throws Exception {


        mockMvc.perform(post("/product")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "    \"id\":1,\n" +
                                "    \"name\":\"\",\n" +
                                "    \"price\":1000,\n" +
                                "    \"description\":\"A device for keeping food cool\",\n" +
                                "    \"supplierDTO\":{\n" +
                                "        \"id\":4,\n" +
                                "    \"name\":\"ElecTech Solutions\",\n" +
                                "    \"address\": \"Evergreen Avenue\"\n" +
                                "}\n" +
                                "}"))
                .andExpect(status().isBadRequest());

    }

    @Test
    public void addProductNoSupplier() throws Exception {


        mockMvc.perform(post("/product")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "    \"name\":\"\",\n" +
                                "    \"price\":-1000,\n" +
                                "    \"description\":\"A device for keeping food cool\",\n" +
                                "    \"categoryDTO\":{\n" +
                                "        \"id\":4,\n" +
                                "    \"name\":\"electronics\"\n" +
                                "}\n" +
                                "}"))
                .andExpect(status().isBadRequest());


    }
    @Test
    public void updateProductNoSupplier() throws Exception {


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
                                "}}"
                                ))
                .andExpect(status().isBadRequest());

    }
}

