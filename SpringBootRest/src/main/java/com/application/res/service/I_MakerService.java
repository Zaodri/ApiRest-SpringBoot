package com.application.res.service;

import com.application.res.entities.Maker;

import java.util.List;
import java.util.Optional;

public interface I_MakerService {

    Optional<Maker> findById(Long id_F);

    List<Maker> findAll();

    void save(Maker maker);

    void delateById(Long id_F);
}
