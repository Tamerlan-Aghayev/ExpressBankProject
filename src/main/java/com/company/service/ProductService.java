package com.company.service;

import com.company.entity.Product;
import com.company.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public void addOrUpdateProduct(Product product)throws DataAccessException , MethodArgumentNotValidException {
        productRepository.saveAndFlush(product);
    }
    public List<Product> getProducts()throws DataAccessException{
        return productRepository.findAll();
    }
    public Product getProductByID(Long id)throws DataAccessException{
        return productRepository.getReferenceById(id);
    }

    public Product deleteProduct(long id) throws DataAccessException{
        Product product=getProductByID(id);
        productRepository.deleteById(id);
        return product;
    }

}
