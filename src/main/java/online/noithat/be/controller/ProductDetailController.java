package online.noithat.be.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import online.noithat.be.Entity.Product;
import online.noithat.be.Entity.ProductDetail;
import online.noithat.be.dto.CreateProductRequestDTO;
import online.noithat.be.dto.response.CreateProductDetailResponseDTO;
import online.noithat.be.service.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@SecurityRequirement(name = "api")
public class ProductDetailController {
    @Autowired
    ProductDetailService productDetailService;

    @PostMapping("/product-detail")
    public ResponseEntity createProductDetail(@RequestBody CreateProductDetailResponseDTO createProductDetailResponseDTO) {
        ProductDetail createdProductDetail = productDetailService.createProductDetail(createProductDetailResponseDTO);
        return ResponseEntity.ok(createdProductDetail);
    }

    @PutMapping("/product-detail/{id}")
    public ResponseEntity update(@PathVariable long id, @RequestBody CreateProductDetailResponseDTO createProductDetailResponseDTO) {

        return ResponseEntity.ok(productDetailService.update(createProductDetailResponseDTO, id));
    }

    @GetMapping("/product-detail")
    public ResponseEntity getAllProductDetail() {
        List<ProductDetail> productDetails = productDetailService.getAllProduct();
        return ResponseEntity.ok(productDetails);
    }

    @GetMapping("/product-detail/{id}")
    public ResponseEntity getProductDetailById(@PathVariable long id) {
        ProductDetail productDetails = productDetailService.getProductDetailById(id);
        return ResponseEntity.ok(productDetails);
    }

    @DeleteMapping("/product-detail/{id}")
    public ResponseEntity delete(@PathVariable long id) {
        return ResponseEntity.ok(productDetailService.delete(id));
    }

//    @GetMapping("/product-detail/{id}")
//    public ResponseEntity getProductDetailByProductId(@PathVariable long id){
//        List<ProductDetail> productDetails = productDetailService.getProductByProductId(id);
//        return ResponseEntity.ok(productDetails);
//    }
}
