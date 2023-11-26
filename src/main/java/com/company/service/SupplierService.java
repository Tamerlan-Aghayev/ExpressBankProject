package com.company.service;

import com.company.entity.Supplier;
import com.company.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;

@Service
@Transactional
public class SupplierService {
    private SupplierRepository supplierRepository;
    @Autowired
    public SupplierService(SupplierRepository supplierRepository)throws DataAccessException {
        this.supplierRepository=supplierRepository;
    }
    public Supplier addSupplier(Supplier supplier)throws DataAccessException, MethodArgumentNotValidException {
        Supplier addedSupplier=supplierRepository.saveAndFlush(supplier);
        return supplier;
    }
    public List<Supplier> getAllSuppliers()throws DataAccessException{
        return supplierRepository.findAll();
    }
    public Supplier getById(long id)throws DataAccessException{
        return supplierRepository.getReferenceById(id);
    }
}
