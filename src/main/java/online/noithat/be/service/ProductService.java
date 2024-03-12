package online.noithat.be.service;

import online.noithat.be.Entity.Product;
import online.noithat.be.Entity.Category;
import online.noithat.be.Entity.ProductDetail;
import online.noithat.be.Entity.Resource;
import online.noithat.be.dto.CreateProductRequestDTO;

import online.noithat.be.dto.request.ResourceDTO;
import online.noithat.be.dto.response.ProductResponseDTO;
import online.noithat.be.repository.ProductCategoryRepository;
import online.noithat.be.repository.ProductDetailRepository;
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

    @Autowired
    ProductDetailRepository productDetailRepository;

    public Product createProduct(CreateProductRequestDTO createProductRequestDTO) {
        ArrayList<Category> categoryList = new ArrayList<>();


        Product product = new Product();
        product.setProductCategories(categoryList);
        product.setName(createProductRequestDTO.getName());
//        product.setPricePerUnit(createProductRequestDTO.getPricePerUnit());
//        product.setProductColors(createProductRequestDTO.getProductColors());
//        product.setPricePerAmount(createProductRequestDTO.getPricePerAmount());
        product.setPricePerUnit(createProductRequestDTO.getPricePerUnit());
        product.setUnit(createProductRequestDTO.getUnit());
        product.setLength(createProductRequestDTO.getLength());
        product.setWidth(createProductRequestDTO.getWidth());
        product.setHeight(createProductRequestDTO.getHeight());
        List<Resource> resources = new ArrayList<>();
        // ResourceDTO => Resource
        for (ResourceDTO resourceDTO : createProductRequestDTO.getResourceDTOS()) {
            Resource resource = new Resource();
            resource.setType(resourceDTO.getType());
            resource.setUrl(resourceDTO.getUrl());
            resource.setProduct(product);
            resources.add(resource);
        }
        product.setResources(resources);

        try{
            for (Long categoryId : createProductRequestDTO.getCategoriesId()) {
                Category category = productCategoryRepository.findProductCategoryById(categoryId);
                category.getProducts().add(product);
                categoryList.add(category);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return productRepository.save(product);
    }

    public List<Product> getAllProduct() {
        List<Product> products = productRepository.findProductsByIdNotNull();
        return products;
    }

    public List<Product> getProductByCategoryId(Long categoryId) {
        Category category = productCategoryRepository.findProductCategoryById(categoryId);
        List<Product> products = productRepository.findProductsByProductCategoriesContaining(category);
        return products;
    }

    public Product update(CreateProductRequestDTO createProductRequestDTO, long id) {
        Product product = productRepository.findProductById(id);
        product.setName(createProductRequestDTO.getName());
        product.setPricePerUnit(createProductRequestDTO.getPricePerUnit());
        product.setProductColors(createProductRequestDTO.getProductColors());
        product.setPricePerAmount(createProductRequestDTO.getPricePerAmount());
        List<Resource> resources = new ArrayList<>();
        // ResourceDTO => Resource
        for (ResourceDTO resourceDTO : createProductRequestDTO.getResourceDTOS()) {
            Resource resource = new Resource();
            resource.setType(resourceDTO.getType());
            resource.setUrl(resourceDTO.getUrl());
            resource.setProduct(product);
            resources.add(resource);
        }
        product.setResources(resources);
        return productRepository.save(product);
    }

    public Product delete(long id) {
        Product product = productRepository.findProductById(id);
        product.setDeleted(true);
        return productRepository.save(product);
    }

    public List<ProductResponseDTO> getProductResponseDTOS() {
        List<ProductResponseDTO> list = new ArrayList<>();
        List<Product> products = productRepository.findProductsByIdNotNull();

        for(Product product: products){
            ProductResponseDTO productResponseDTO = new ProductResponseDTO();
            productResponseDTO.setProductId(product.getId());
            productResponseDTO.setName(product.getName());
            productResponseDTO.setLength(product.getLength());
            productResponseDTO.setWidth(product.getWidth());
            productResponseDTO.setHeight(product.getHeight());
            productResponseDTO.setWeight(0);
            productResponseDTO.setUnit(product.getUnit());

            productResponseDTO.setPricePerUnit(product.getPricePerUnit());
            productResponseDTO.setTotal(0);
            productResponseDTO.setImage(product.getResources().get(0).getUrl());
            list.add(productResponseDTO);
        }

        return list;
    }
}
