package online.noithat.be.service;

import online.noithat.be.Entity.Product;
import online.noithat.be.Entity.Category;
import online.noithat.be.dto.CreateProductRequestDTO;
import online.noithat.be.repository.ProductCategoryRepository;
import online.noithat.be.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductCategoryRepository productCategoryRepository;
    public Product createProduct(CreateProductRequestDTO createProductRequestDTO){
        ArrayList<Category> categoryList = new ArrayList<>();



        Product product = new Product();
        product.setProductCategories(categoryList);
        product.setName(createProductRequestDTO.getName());
        product.setPrice(createProductRequestDTO.getPrice());
        product.setImg(createProductRequestDTO.getImg());
        for (Long categoryId : createProductRequestDTO.getCategoriesId()){
            Category category = productCategoryRepository.findProductCategoryById(categoryId);
            category.getProducts().add(product);
            categoryList.add(category);
        }
        return productRepository.save(product);
    }

    public List<Product> getAllProduct(){
        List<Product> products = productRepository.findProductsByIdNotNull();
        return products;
    }
    public List<Product> getProductByCategoryId(Long categoryId){
        Category category = productCategoryRepository.findProductCategoryById(categoryId);
        List<Product> products= productRepository.findProductsByProductCategoriesContaining(category);
        return products;
    }
    public Product update(long id,String newName,Float price, String img){
        Product product = productRepository.findProductById(id);
        product.setName(newName);
        product.setPrice(price);
        product.setImg(img);
        return productRepository.save(product);
    }
    public Product delete(long id){
        Product product = productRepository.findProductById(id);
        product.setDeleted(true);
        return productRepository.save(product);
    }
}
