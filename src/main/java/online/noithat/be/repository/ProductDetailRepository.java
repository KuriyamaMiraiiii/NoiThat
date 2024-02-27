package online.noithat.be.repository;

import online.noithat.be.Entity.ProductDetail;

import java.util.List;

public interface ProductDetailRepository {
    List<ProductDetail> findProductsByIdNotNull();
    ProductDetail findProductById(Long id);
}
