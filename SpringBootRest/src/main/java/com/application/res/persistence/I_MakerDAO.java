package com.application.res.persistence;

import com.application.res.entities.*;

import java.util.List;
import java.util.Optional;

public interface I_MakerDAO {

    Optional<Maker> findById(Long id_F);

    List<Maker> findAll();

    void save(Maker maker);

    void delateById(Long id_F);


}
