package com.application.res.repository;

import com.application.res.entities.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    /* utilizamos sentencia con jQueryMetod*/
    List<Product> findProductByPrecioProdBetween(BigDecimal minPrecioProd, BigDecimal maxPrecioProd);

    /* otra forma ser[ia utilizando la notacion Query*/
    @Query("SELECT p FROM Product p WHERE p.precioProd >= ?1 AND p.precioProd <= ?2")
    List<Product> findProductByPrecioProdInRangeAnd(BigDecimal minPrecioProd, BigDecimal maxPrecioProd);

    /* otra forma es utilizando BETWEEN en la notacion Query*/
    /* @Query("SELECT p FROM Product p WHERE p.precioProd BETWEEN ?1 AND ?2")
     * List<Product> findProductByPrecioProdInRangeAnd(BigDecimal minPrecioProd, BigDecimal maxPrecioProd);
     **/
}
