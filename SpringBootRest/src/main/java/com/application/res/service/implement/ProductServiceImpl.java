package com.application.res.service.implement;

import com.application.res.entities.Product;
import com.application.res.persistence.I_ProductDAO;
import com.application.res.service.I_ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements I_ProductService {

    @Autowired
    private I_ProductDAO i_productDAO;

    @Override
    public List<Product> findAll() {
        return i_productDAO.findAll();
    }

    @Override
    public Optional<Product> findById(Long Id_Prod) {
        return i_productDAO.findById(Id_Prod);
    }

    @Override
    public List<Product> findByPrecioProdInRange(BigDecimal minPrecioProd, BigDecimal maxPrecioProd) {
        return i_productDAO.findByPrecioProdInRange(minPrecioProd, maxPrecioProd);
    }

    @Override
    public void save(Product product) {
        i_productDAO.save(product);
    }

    @Override
    public void deleteById(Long Id_Prod) {
        i_productDAO.deleteById(Id_Prod);
    }
}
