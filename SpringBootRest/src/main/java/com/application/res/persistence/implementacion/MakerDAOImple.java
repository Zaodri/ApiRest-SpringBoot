package com.application.res.persistence.implementacion;

import com.application.res.entities.Maker;
import com.application.res.persistence.I_MakerDAO;
import com.application.res.repository.MakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MakerDAOImple implements I_MakerDAO {

    @Autowired
    private MakerRepository makerRepository;

    @Override
    public Optional<Maker> findById(Long id_F) {
        return makerRepository.findById(id_F);
    }

    @Override
    public List<Maker> findAll() {
        return (List<Maker>) makerRepository.findAll();
    }

    @Override
    public void save(Maker maker) {
        makerRepository.save(maker);
    }

    @Override
    public void delateById(Long id_F) {
        makerRepository.deleteById(id_F);
    }
}
