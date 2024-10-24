package com.application.res.controllers;


import com.application.res.controllers.dto.MakerDTO;
import com.application.res.entities.Maker;
import com.application.res.service.I_MakerService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/maker")
public class MakerController {

    @Autowired
    private I_MakerService i_makerServiceC;

    @GetMapping("/find/{id_F}")
    public ResponseEntity<?> findById(@PathVariable Long id_F) {
        Optional<Maker> makerOptional = i_makerServiceC.findById(id_F);

        if (makerOptional.isPresent()) {
            Maker maker = makerOptional.get();
            MakerDTO makerDTO = MakerDTO.builder()
                    .id_F(maker.getId_F())
                    .nombreF(maker.getNombreF())
                    .productList(maker.getProductList())
                    .build();

            return ResponseEntity.ok(makerDTO);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        List<MakerDTO> makerDTOList = i_makerServiceC.findAll()
                .stream()
                .map(maker -> MakerDTO.builder()
                        .id_F(maker.getId_F())
                        .nombreF(maker.getNombreF())
                        .productList(maker.getProductList())
                        .build())
                .toList();

        return ResponseEntity.ok(makerDTOList);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody @NonNull MakerDTO makerDTO) throws URISyntaxException {
        if (makerDTO.getNombreF().isBlank()) {
            return ResponseEntity.badRequest().build();
        }

        i_makerServiceC.save(Maker
                .builder()
                .nombreF(makerDTO.getNombreF())
                .build());

        return ResponseEntity.created(new URI("/api/maker/save")).build();
    }

    @PutMapping("/update/{id_F}")
    public ResponseEntity<?> updateMaker(@PathVariable Long id_F, @RequestBody MakerDTO makerDTO) {
        Optional<Maker> makerOptional = i_makerServiceC.findById(id_F);
        if (makerOptional.isPresent()) {
            Maker maker = makerOptional.get();
            maker.setNombreF(makerDTO.getNombreF());
            i_makerServiceC.save(maker);
            return ResponseEntity.ok("Registro actualizado ");
        }
        return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/delete/{id_F}")
    public ResponseEntity<?> deleteById(@PathVariable Long id_F) {
        if (id_F != null) {
            i_makerServiceC.delateById(id_F);
            return ResponseEntity.ok("Registro eliminado");
        }
        return ResponseEntity.badRequest().build();
    }
}
