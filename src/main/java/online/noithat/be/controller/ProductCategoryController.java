package online.noithat.be.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import online.noithat.be.Entity.Category;
import online.noithat.be.dto.request.CategoryRequestDTO;
import online.noithat.be.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@SecurityRequirement(name = "api")
public class ProductCategoryController {
    @Autowired
    ProductCategoryService productCategoryService;

    @PostMapping("/category")
    public ResponseEntity createProductCategory(@RequestBody Category category) {
        Category createdCategory = productCategoryService.createProductCategory(category);
        return ResponseEntity.ok(createdCategory);
    }

    @GetMapping("/categories")
    public ResponseEntity getAllProductCategory() {
        List<Category> productCategories = productCategoryService.getAllCategories();
        return ResponseEntity.ok(productCategories);
    }

    @DeleteMapping("/category/{id}")
    public ResponseEntity delete(@PathVariable long id) {
        return ResponseEntity.ok(productCategoryService.delete(id));
    }
    @PutMapping("/category/{id}")
    public ResponseEntity update(@PathVariable long id, @RequestBody CategoryRequestDTO categoryRequestDTO){
        return ResponseEntity.ok(productCategoryService.update(id,categoryRequestDTO.getName()));
    }
}

