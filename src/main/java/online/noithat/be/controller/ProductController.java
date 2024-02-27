package online.noithat.be.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import online.noithat.be.Entity.Product;
import online.noithat.be.dto.CreateProductRequestDTO;
import online.noithat.be.dto.request.ProductRequestDTO;
import online.noithat.be.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@SecurityRequirement(name = "api")
public class ProductController {
    @Autowired
    ProductService productService;
    @PostMapping("/product")
    public ResponseEntity createProduct(@RequestBody CreateProductRequestDTO createProductRequestDTO){
        Product createdProduct = productService.createProduct(createProductRequestDTO);
        return ResponseEntity.ok(createdProduct);
    }

    @PutMapping("/product/{id}")
    public ResponseEntity update(@PathVariable long id, @RequestBody CreateProductRequestDTO createProductRequestDTO){

        return ResponseEntity.ok(productService.update(createProductRequestDTO, id));
    }

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

    @DeleteMapping("/product/{id}")
    public ResponseEntity delete(@PathVariable long id){
        return ResponseEntity.ok(productService.delete(id));
    }

}
