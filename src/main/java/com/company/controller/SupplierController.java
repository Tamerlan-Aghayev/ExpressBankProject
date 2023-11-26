package com.company.controller;

import com.company.dto.ResponseDTO;
import com.company.dto.SupplierDTO;
import com.company.entity.Supplier;
import com.company.service.SupplierService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class SupplierController {
    private final SupplierService supplierService;

    @Autowired
    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @PostMapping("/supplier")
    public ResponseEntity<ResponseDTO> addSupplier(@RequestBody @Valid SupplierDTO dto) {
        try {
            Supplier supplier = new Supplier();
            supplier.setName(dto.getName());
            supplier.setAddress(dto.getAddress());
            Supplier addedSupplier=supplierService.addSupplier(supplier);
            return ResponseEntity.status(HttpStatus.CREATED).body(ResponseDTO.of(new SupplierDTO(addedSupplier), "success"));
        } catch (DataAccessException ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ResponseDTO.of("Error while adding supplier"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseDTO.of("Bad Request"));
        }
    }

    @GetMapping("/suppliers")
    public ResponseEntity<ResponseDTO> getAllSuppliers() {
        try {
            List<Supplier> suppliers = supplierService.getAllSuppliers();
            List<SupplierDTO> supplierDTOs = new ArrayList<>();
            for (Supplier supplier : suppliers) {
                supplierDTOs.add(new SupplierDTO(supplier));
            }
            return ResponseEntity.status(HttpStatus.OK).body(ResponseDTO.of(supplierDTOs, "success"));
        } catch (DataAccessException ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ResponseDTO.of("Error while getting suppliers"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseDTO.of("Bad Request"));
        }
    }


}
