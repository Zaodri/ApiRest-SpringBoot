package com.application.res.persistence.implementacion;

import com.application.res.entities.Product;
import com.application.res.persistence.I_ProductDAO;
import com.application.res.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Component
public class ProductDAOImple implements I_ProductDAO {

    @Autowired
    private ProductRepository productRepository;


    @Override
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long Id_Prod) {
        return productRepository.findById(Id_Prod);
    }

    @Override
    public List<Product> findByPrecioProdInRange(BigDecimal minPrecioProd, BigDecimal maxPrecioProd) {
        return productRepository.findProductByPrecioProdInRangeAnd(minPrecioProd, maxPrecioProd);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);

    }

    @Override
    public void deleteById(Long Id_Prod) {
        productRepository.deleteById(Id_Prod);

    }
}
