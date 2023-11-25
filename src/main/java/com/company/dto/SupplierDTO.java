package com.company.dto;

import com.company.entity.Supplier;

public class SupplierDTO {
    private long id;
    private String name;
    private String address;
    public SupplierDTO(){}
    public SupplierDTO(Supplier supplier) {
        this.id = supplier.getId();
        this.name = supplier.getName();
        this.address = supplier.getAddress();
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
