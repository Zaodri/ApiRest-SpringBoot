package com.application.res.service;

import com.application.res.entities.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface I_ProductService {

    List<Product> findAll();

    Optional<Product> findById(Long Id_Prod);

    List<Product> findByPrecioProdInRange(BigDecimal minPrecioProd, BigDecimal maxPrecioProd);

    void save(Product product);

    void deleteById(Long Id_Prod);
}
