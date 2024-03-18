package online.noithat.be.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import online.noithat.be.Entity.ProductColor;
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

    @PostMapping("/productMaterial/{id}")
    public ResponseEntity createProductMaterial(@RequestBody ProductMaterialRequestDTO productMaterialRequestDTO, @PathVariable long id) {
        ProductMaterial createdProductMaterial = productMaterialService.createProductMaterial(productMaterialRequestDTO, id);
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

    @GetMapping("/productMaterial-productId/{id}")
    public ResponseEntity getProductMaterialByProductId(@PathVariable long id) {
        List<ProductMaterial> productMaterials = productMaterialService.getProductMaterialByProductId(id);
        return ResponseEntity.ok(productMaterials);
    }
}
