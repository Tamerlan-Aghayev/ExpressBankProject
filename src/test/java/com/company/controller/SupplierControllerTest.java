package com.company.controller;

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
public class SupplierControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SupplierService supplierService;
    @Test
    public void getSuppliers() throws Exception {

        List<Supplier> suppliers=new ArrayList<>();
        when(supplierService.getAllSuppliers()).thenReturn(suppliers);

        mockMvc.perform(get("/suppliers"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("success"));;
    }
    @Test
    public void addSupply() throws Exception {
        Supplier supplier=new Supplier("ElecTech", "Baku");
        when(supplierService.addSupplier(supplier)).thenReturn(supplier);
        mockMvc.perform(post("/supplier")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"name\": \"ElecTech\", \"address\": \"Baku\"}"))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("success"));


    }

}
