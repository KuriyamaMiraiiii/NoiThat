package online.noithat.be.service;

import online.noithat.be.Entity.Category;
import online.noithat.be.Entity.ProductColor;
import online.noithat.be.repository.ProductColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductColorService {
    @Autowired
    ProductColorRepository productColorRepository;
    public ProductColor createProductColor(ProductColor color){

//        product.setProductId(product.getProductId());
        color.setColor(color.getColor());
        return productColorRepository.save(color);
    }


    public List<ProductColor> getAllProductColors(){
        List<ProductColor> productColors = productColorRepository.findProductColorsByIdNotNull();
        return productColors;
    }

    public ProductColor delete(long id){
        ProductColor color = productColorRepository.findProductColorById(id);
        color.setDeleted(true);
        return productColorRepository.save(color);
    }

    public ProductColor update(long id, String newColor){
        ProductColor color = productColorRepository.findProductColorById(id);
        color.setColor(newColor);
        return productColorRepository.save(color);
    }

    public ProductColor add(ProductColor color){
        return productColorRepository.save(color);
    }
}
