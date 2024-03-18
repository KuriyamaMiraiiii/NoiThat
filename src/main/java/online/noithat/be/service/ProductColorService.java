package online.noithat.be.service;

import online.noithat.be.Entity.Category;
import online.noithat.be.Entity.Product;
import online.noithat.be.Entity.ProductColor;
import online.noithat.be.dto.request.ProductColorRequestDTO;
import online.noithat.be.repository.ProductColorRepository;
import online.noithat.be.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductColorService {
    @Autowired
    ProductColorRepository productColorRepository;
    @Autowired
    ProductRepository productRepository;
    public ProductColor createProductColor(ProductColorRequestDTO productColorRequestDTO, long id){
        ProductColor color = new ProductColor();
        Product product = productRepository.findProductById(id);
        color.setColor(productColorRequestDTO.getColor());
        color.setProduct(product);
        return productColorRepository.save(color);
    }


    public List<ProductColor> getAllProductColors(){
        List<ProductColor> productColors = productColorRepository.findProductColorsByIdNotNull();
        return productColors;
    }

    public List<ProductColor> getProductColorsByProductId(long id){
        Product product = productRepository.findProductById(id);

        List<ProductColor> productColors = productColorRepository.findProductColorsByProduct(product);
        return  productColors;
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
