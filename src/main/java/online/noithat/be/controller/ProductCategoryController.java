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
    @PostMapping("/productCategory")
    public ResponseEntity createProductCategory(@RequestBody Category category){
        Category createdCategory = productCategoryService.createProductCategory(category);
        return ResponseEntity.ok(createdCategory);
    }
//
//    @PutMapping("/productCategory")
//
//    @GetMapping("/productCategory")
    @GetMapping("/productCategory")
    public ResponseEntity getAllProductCategory() {
        List<Category> productCategories = productCategoryService.getAllProduct();
        return ResponseEntity.ok(productCategories);
    }
//    @GetMapping("/productCategory/{id}")
//
//    @DeleteMapping("/productCategory/{id}")
}
