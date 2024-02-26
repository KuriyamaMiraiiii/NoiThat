package online.noithat.be.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import online.noithat.be.Entity.ProductMaterial;
import online.noithat.be.dto.request.ProductColorRequestDTO;
import online.noithat.be.dto.request.ProductMaterialRequestDTO;
import online.noithat.be.service.ProductMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@SecurityRequirement(name = "api")
public class ProductMaterialController {
    @Autowired
    ProductMaterialService productMaterialService;

    @PostMapping("/productMaterial")
    public ResponseEntity createProductMaterial(@RequestBody ProductMaterial productMaterial) {
        ProductMaterial createdProductMaterial = productMaterialService.createProductMaterial(productMaterial);
        return ResponseEntity.ok(createdProductMaterial);
    }

    @GetMapping("/productMaterials")
    public ResponseEntity getAllProductMaterials() {
        List<ProductMaterial> productMaterials = productMaterialService.getAllProductMaterials();
        return ResponseEntity.ok(productMaterials);
    }

    @DeleteMapping("/productMaterial/{id}")
    public ResponseEntity delete(@PathVariable long id) {
        return ResponseEntity.ok(productMaterialService.delete(id));
    }
    @PutMapping("/productMaterial/{id}")
    public ResponseEntity update(@PathVariable long id, @RequestBody ProductMaterialRequestDTO productMaterialRequestDTO){
        return ResponseEntity.ok(productMaterialService.update(id, productMaterialRequestDTO.getSize()));
    }
}
