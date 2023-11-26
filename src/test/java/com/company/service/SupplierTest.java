package com.company.service;

import com.company.entity.Supplier;
import com.company.repository.SupplierRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.web.bind.MethodArgumentNotValidException;

public class SupplierTest {
    @Mock
    private SupplierRepository supplierRepository;
    @InjectMocks
    private  SupplierService supplierService;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void addSupplier() throws MethodArgumentNotValidException {
        Supplier supplier=new Supplier();
        supplier.setName("TechnoMarket");
        supplier.setAddress("Baku");
        supplierService.addSupplier(supplier);
        Mockito.verify(supplierRepository, Mockito.atLeastOnce()).saveAndFlush(supplier);
    }
    @Test
    public void getCategories()  {

        supplierService.getAllSuppliers();
        Mockito.verify(supplierRepository, Mockito.atLeastOnce()).findAll();
    }
    @Test
    public void getCategoryByID()  {

        supplierService.getById(5);
        Mockito.verify(supplierRepository, Mockito.atLeastOnce()).getReferenceById((long)5);
    }
}
