package com.application.res.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;


@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "producto")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id_Prod;

    @Column(name = "nombreP")
    private String nombreProd;

    @Column(name = "precioP")
    private BigDecimal precioProd;

    @ManyToOne
    @JoinColumn(name = "id_fabricante", nullable = false)
    @JsonIgnore
    private Maker maker;
}
