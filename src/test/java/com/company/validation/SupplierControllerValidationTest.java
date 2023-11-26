package com.company.validation;


import com.company.controller.SupplierController;
import com.company.entity.Category;
import com.company.entity.Supplier;
import com.company.service.SupplierService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(SupplierController.class)
public class SupplierControllerValidationTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SupplierService supplierService;

    @Test
    public void addSupplyNoName() throws Exception {
        mockMvc.perform(post("/supplier")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"name\": \"\", \"address\": \"Baku\"}"))
                .andExpect(status().isBadRequest());
    }
    @Test
    public void addSupplyShortName() throws Exception {
        mockMvc.perform(post("/supplier")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"name\": \"a\", \"address\": \"Baku\"}"))
                .andExpect(status().isBadRequest());
    }

}