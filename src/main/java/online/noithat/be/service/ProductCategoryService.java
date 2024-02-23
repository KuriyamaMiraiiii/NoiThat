package online.noithat.be.service;

import online.noithat.be.Entity.Category;
import online.noithat.be.repository.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryService {
    @Autowired
    ProductCategoryRepository productCategoryRepository;
    public Category createProductCategory(Category category){

//        product.setProductId(product.getProductId());
        category.setName(category.getName());
        return productCategoryRepository.save(category);
    }
    public List<Category> getAllProduct(){
        List<Category> productCategories = productCategoryRepository.findProductCategoriesByProductCategoryIdNotNull();
        return productCategories;
    }
}
