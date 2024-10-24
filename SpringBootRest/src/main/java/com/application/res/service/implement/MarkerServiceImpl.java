package com.application.res.service.implement;

import com.application.res.entities.Maker;
import com.application.res.persistence.I_MakerDAO;
import com.application.res.service.I_MakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarkerServiceImpl implements I_MakerService {

    @Autowired
    private I_MakerDAO i_makerDAO;

    @Override
    public Optional<Maker> findById(Long id_F) {
        return i_makerDAO.findById(id_F);
    }

    @Override
    public List<Maker> findAll() {
        return i_makerDAO.findAll();
    }

    @Override
    public void save(Maker maker) {
        i_makerDAO.save(maker);
    }

    @Override
    public void delateById(Long id_F) {
        i_makerDAO.delateById(id_F);
    }
}
