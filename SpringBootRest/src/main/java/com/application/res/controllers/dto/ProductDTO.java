package com.application.res.controllers.dto;

import com.application.res.entities.Maker;
import com.application.res.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDTO {

    private Long Id_Prod;
    private String nombreProd;
    private BigDecimal precioProd;
    private Maker maker;

}
