package online.noithat.be.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import online.noithat.be.Entity.Category;
import online.noithat.be.Entity.ProductColor;
import online.noithat.be.dto.request.CategoryRequestDTO;
import online.noithat.be.dto.request.ProductColorRequestDTO;
import online.noithat.be.service.ProductColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@SecurityRequirement(name = "api")
public class ProductColorController {
    @Autowired
    ProductColorService productColorService;

    @PostMapping("/productColor/{id}")
    public ResponseEntity createProductColor(@RequestBody ProductColorRequestDTO productColorRequestDTO, @PathVariable long id) {
        ProductColor createdProductColor = productColorService.createProductColor(productColorRequestDTO,id);
        return ResponseEntity.ok(createdProductColor);
    }

    @GetMapping("/productColors")
    public ResponseEntity getAllProductColor() {
        List<ProductColor> productColors = productColorService.getAllProductColors();
        return ResponseEntity.ok(productColors);
    }

    @DeleteMapping("/productColor/{id}")
    public ResponseEntity delete(@PathVariable long id) {
        return ResponseEntity.ok(productColorService.delete(id));
    }
    @PutMapping("/productColor/{id}")
    public ResponseEntity update(@PathVariable long id, @RequestBody ProductColorRequestDTO productColorRequestDTO){
        return ResponseEntity.ok(productColorService.update(id,productColorRequestDTO.getColor()));
    }
}
