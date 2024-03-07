package online.noithat.be.service;

import online.noithat.be.Entity.Category;
import online.noithat.be.Entity.ProjectType;
import online.noithat.be.dto.request.CategoryRequestDTO;
import online.noithat.be.dto.request.ProjectTypeRequestDTO;
import online.noithat.be.repository.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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


    public List<Category> getAllCategories(){
        List<Category> productCategories = productCategoryRepository.findProductCategoriesByIdNotNull();
        return productCategories;
    }

    public Category delete(long id){
        Category category = productCategoryRepository.findProductCategoryById(id);
        category.setDeleted(true);
        return productCategoryRepository.save(category);
    }

    public Category update(long id, String newName){
        Category category = productCategoryRepository.findProductCategoryById(id);
        category.setName(newName);
        return productCategoryRepository.save(category);
    }

    public Category add(Category category){
        return productCategoryRepository.save(category);
    }




}
