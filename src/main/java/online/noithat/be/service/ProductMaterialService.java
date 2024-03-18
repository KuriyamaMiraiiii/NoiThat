package online.noithat.be.service;

import online.noithat.be.Entity.Product;
import online.noithat.be.Entity.ProductColor;
import online.noithat.be.Entity.ProductMaterial;
import online.noithat.be.dto.request.ProductColorRequestDTO;
import online.noithat.be.dto.request.ProductMaterialRequestDTO;
import online.noithat.be.repository.ProductMaterialRepository;
import online.noithat.be.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductMaterialService {
    @Autowired
    ProductMaterialRepository productMaterialRepository;

    @Autowired
    ProductRepository productRepository;

    public ProductMaterial createProductMaterial(ProductMaterialRequestDTO productMaterialRequestDTO, long id){
        ProductMaterial productMaterial = new ProductMaterial();
        Product product = productRepository.findProductById(id);
        productMaterial.setSize(productMaterialRequestDTO.getSize());
        productMaterial.setProduct(product);
        return productMaterialRepository.save(productMaterial);
    }


    public List<ProductMaterial> getAllProductMaterials(){
        List<ProductMaterial> productMaterials = productMaterialRepository.findProductMaterialsByIdNotNull();
        return productMaterials;
    }

    public List<ProductMaterial> getProductMaterialByProductId(long id){
        Product product = productRepository.findProductById(id);

        List<ProductMaterial> productMaterials = productMaterialRepository.findProductMaterialsByProduct(product);
        return  productMaterials;
    }

    public ProductMaterial delete(long id){
        ProductMaterial productMaterial = productMaterialRepository.findProductMaterialById(id);
        productMaterial.setDeleted(true);
        return productMaterialRepository.save(productMaterial);
    }

    public ProductMaterial update(long id, String newSize){
        ProductMaterial productMaterial = productMaterialRepository.findProductMaterialById(id);
        productMaterial.setSize(newSize);
        return productMaterialRepository.save(productMaterial);
    }

    public ProductMaterial add(ProductMaterial productMaterial){
        return productMaterialRepository.save(productMaterial);
    }
}
