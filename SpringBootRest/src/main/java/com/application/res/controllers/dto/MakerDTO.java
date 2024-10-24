package com.application.res.controllers.dto;

import com.application.res.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MakerDTO {

    private Long id_F;
    private String nombreF;
    private List<Product> productList = new ArrayList<>();
}
