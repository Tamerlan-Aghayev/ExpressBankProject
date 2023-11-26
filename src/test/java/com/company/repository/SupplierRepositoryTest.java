package com.company.repository;

import com.company.entity.Category;
import com.company.entity.Supplier;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SupplierRepositoryTest {
    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private TestEntityManager entityManager;
    @BeforeEach
    void setup() {
        Supplier supplier=new Supplier(1l, "ElecTech", "Baku");
        entityManager.merge(supplier);
    }
    @Test
    public void saveAndFlush(){
        Supplier supplier=supplierRepository.saveAndFlush(new Supplier(2l, "Mr.Fix", "Baku"));
        Assertions.assertNotNull(supplier);
    }
    @Test
    public void findAll(){
        List<Supplier> suppliers=supplierRepository.findAll();
        Assertions.assertEquals(1, suppliers.size());
    }
}
