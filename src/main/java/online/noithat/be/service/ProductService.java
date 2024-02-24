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

        for (Long categoryId : createProductRequestDTO.getCategoriesId()){
            Category category = productCategoryRepository.findProductCategoryById(categoryId);
            categoryList.add(category);
        }

        Product product = new Product();
        product.setProductCategories(categoryList);
        product.setName(createProductRequestDTO.getName());
        product.setPrice(createProductRequestDTO.getPrice());
        product.setImg(createProductRequestDTO.getImg());
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
}
