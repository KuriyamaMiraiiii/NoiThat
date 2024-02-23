package online.noithat.be.controller;

import online.noithat.be.Entity.Product;
import online.noithat.be.dto.CreateProductRequestDTO;
import online.noithat.be.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ProductController {
    @Autowired
    ProductService productService;
    @PostMapping("/product")
    public ResponseEntity createProduct(@RequestBody CreateProductRequestDTO createProductRequestDTO){
        Product createdProduct = productService.createProduct(createProductRequestDTO);
        return ResponseEntity.ok(createdProduct);
    }

//    @PutMapping("/product")
//
    @GetMapping("/product")
    public ResponseEntity getAllProduct(){
        List<Product> products = productService.getAllProduct();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity getProductByCategoryId(@PathVariable long id){
        List<Product> products = productService.getProductByCategoryId(id);
        return ResponseEntity.ok(products);
    }
//
//    @DeleteMapping("/product/{id}")
        public ResponseEntity deleteProductById(@PathVariable long id){
        return null;
        }

}
