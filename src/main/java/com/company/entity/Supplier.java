package com.company.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.Objects;

@Entity
public class Supplier {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @NotBlank
    @Size(min = 3, max = 50)
    @Column(name = "name", nullable = false)
    private String name;
    @Basic
    @Column(name = "address")
    private String address;
    @OneToMany(mappedBy = "supplierBySupplierId")
    private List<Product> productsById;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Supplier supplier = (Supplier) o;
        return id == supplier.id && Objects.equals(name, supplier.name) && Objects.equals(address, supplier.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address);
    }

    public List<Product> getProductsById() {
        return productsById;
    }

    public void setProductsById(List<Product> productsById) {
        this.productsById = productsById;
    }
}
