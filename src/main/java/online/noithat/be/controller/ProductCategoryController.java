package online.noithat.be.controller;

import online.noithat.be.Entity.Category;
import online.noithat.be.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
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
    public ResponseEntity delete(long id) {
        return ResponseEntity.ok(productCategoryService.delete(id));
    }
    @PutMapping("/category/{id}")
    public ResponseEntity update(long id){
        return ResponseEntity.ok(update(id));
    }
}

