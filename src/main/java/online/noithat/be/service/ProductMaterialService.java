package online.noithat.be.service;

import online.noithat.be.Entity.ProductColor;
import online.noithat.be.Entity.ProductMaterial;
import online.noithat.be.repository.ProductMaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductMaterialService {
    @Autowired
    ProductMaterialRepository productMaterialRepository;
    public ProductMaterial createProductMaterial(ProductMaterial productMaterial){

//        product.setProductId(product.getProductId());
        productMaterial.setSize(productMaterial.getSize());
        return productMaterialRepository.save(productMaterial);
    }


    public List<ProductMaterial> getAllProductMaterials(){
        List<ProductMaterial> productMaterials = productMaterialRepository.findProductMaterialsByIdNotNull();
        return productMaterials;
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
