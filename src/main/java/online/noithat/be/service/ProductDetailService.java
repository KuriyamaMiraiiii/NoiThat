package online.noithat.be.service;

import online.noithat.be.Entity.*;
import online.noithat.be.dto.CreateProductRequestDTO;
import online.noithat.be.dto.request.ResourceDTO;
import online.noithat.be.dto.request.TemplateDTO;
import online.noithat.be.dto.response.CreateProductDetailResponseDTO;
import online.noithat.be.repository.ProductColorRepository;
import online.noithat.be.repository.ProductDetailRepository;
import online.noithat.be.repository.ProductMaterialRepository;
import online.noithat.be.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductDetailService {
    @Autowired
    ProductDetailRepository productDetailRepository;

    @Autowired
    ProductMaterialRepository productMaterialRepository;

    @Autowired
    ProductColorRepository productColorRepository;

    @Autowired
    ProductRepository productRepository;

    public ProductDetail createProductDetail(CreateProductDetailResponseDTO createProductDetailResponseDTO){

        ProductDetail productDetail = new ProductDetail();
        ProductMaterial productMaterial = productMaterialRepository.findProductMaterialById(createProductDetailResponseDTO.getMaterialId());
        productDetail.setMaterial(productMaterial);

        ProductColor productColor = productColorRepository.findProductColorById(createProductDetailResponseDTO.getColorId());
        productDetail.setColor(productColor);

        Product product = productRepository.findProductById(createProductDetailResponseDTO.getProductId());
        productDetail.setProduct(product);

        List<Resource> resources = new ArrayList<>();
        for(ResourceDTO resourceDTO : createProductDetailResponseDTO.getResourceDTOS()){
            Resource resource = new Resource();
            resource.setType(resourceDTO.getType());
            resource.setUrl(resourceDTO.getUrl());
            resource.setProductDetail(productDetail);
            resources.add(resource);
        }

        productDetail.setResources(resources);

        return  productDetailRepository.save(productDetail);
    }

    public List<ProductDetail> getAllProduct(){
        List<ProductDetail> productDetails = productDetailRepository.findProductDetailsByIdNotNull();
        return productDetails;
    }

    public ProductDetail getProductDetailById(long id){
        ProductDetail productDetail = productDetailRepository.findProductDetailById(id);
        return productDetail;
    }

//    public List<ProductDetail> getProductByProductId(Long productId){
//        Product product = productRepository.findProductById(productId);
//        List<ProductDetail> productDetails= productDetailRepository.findProductDetailsByProductContaining(product);
//        return productDetails;
//    }


    public ProductDetail delete(long id){
        ProductDetail productDetail = productDetailRepository.findProductDetailById(id);
        productDetail.setDeleted(true);
        return productDetailRepository.save(productDetail);
    }

    public ProductDetail update(CreateProductDetailResponseDTO createProductDetailResponseDTO, long id){
        ProductDetail productDetail = productDetailRepository.findProductDetailById(id);

        ProductMaterial productMaterial = productMaterialRepository.findProductMaterialById(createProductDetailResponseDTO.getMaterialId());
        productDetail.setMaterial(productMaterial);

        ProductColor productColor = productColorRepository.findProductColorById(createProductDetailResponseDTO.getColorId());
        productDetail.setColor(productColor);

        Product product = productRepository.findProductById(createProductDetailResponseDTO.getProductId());
        productDetail.setProduct(product);


        List<Resource> resources = new ArrayList<>();
        for(ResourceDTO resourceDTO : createProductDetailResponseDTO.getResourceDTOS()) {
            Resource resource = new Resource();
            resource.setType(resourceDTO.getType());
            resource.setUrl(resourceDTO.getUrl());
            resource.setProductDetail(productDetail);
            resources.add(resource);
        }

        productDetail.setResources(resources);

        return  productDetailRepository.save(productDetail);
    }
}
