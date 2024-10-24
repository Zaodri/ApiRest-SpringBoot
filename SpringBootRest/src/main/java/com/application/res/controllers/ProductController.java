package com.application.res.controllers;

import com.application.res.controllers.dto.ProductDTO;
import com.application.res.entities.Product;
import com.application.res.service.I_ProductService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private I_ProductService i_productServiceC;

    @GetMapping("/find/{Id_Prod}")
    public ResponseEntity<?> findById(@PathVariable Long Id_Prod) {
        Optional<Product> productOptional = i_productServiceC.findById(Id_Prod);

        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            ProductDTO productDTO = ProductDTO.builder()
                    .Id_Prod(product.getId_Prod())
                    .nombreProd(product.getNombreProd())
                    .precioProd(product.getPrecioProd())
                    .maker(product.getMaker())
                    .build();
            return ResponseEntity.ok(productDTO);
        }

        return ResponseEntity.badRequest().build(); /*tambien se puede usar notFound()*/

    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        List<ProductDTO> productDTOList = i_productServiceC.findAll()
                .stream()
                .map(product -> ProductDTO.builder()
                        .Id_Prod(product.getId_Prod())
                        .nombreProd(product.getNombreProd())
                        .precioProd(product.getPrecioProd())
                        .maker(product.getMaker())
                        .build())
                .toList();
        return ResponseEntity.ok(productDTOList);

    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody ProductDTO productDTO) throws URISyntaxException {
        if (productDTO.getNombreProd().isBlank()) {
            return ResponseEntity.badRequest().build();
        }

        //creando entidad
        Product product = Product.builder()
                .nombreProd(productDTO.getNombreProd())
                .precioProd(productDTO.getPrecioProd())
                .maker(productDTO.getMaker())
                .build();

        i_productServiceC.save(product);

        return ResponseEntity.created(new URI("/api/product/save")).build();
    }

    @PutMapping("/update/{Id_Prod}")
    public ResponseEntity<?> updateProduct(@PathVariable Long Id_Prod, @RequestBody ProductDTO productDTO) {
        Optional<Product> productOptional = i_productServiceC.findById(Id_Prod);

        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            product.setNombreProd(productDTO.getNombreProd());
            product.setPrecioProd(productDTO.getPrecioProd());
            product.setMaker(productDTO.getMaker());

            i_productServiceC.save(product);

            return ResponseEntity.ok("Registro actualizado");
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{Id_Prod}")
    public ResponseEntity<?> deleteById(@PathVariable Long Id_Prod) {
        if (Id_Prod != null) {
            i_productServiceC.deleteById(Id_Prod);
            return ResponseEntity.ok("Registro eliminado");
        }

        return ResponseEntity.badRequest().build();
    }
}
