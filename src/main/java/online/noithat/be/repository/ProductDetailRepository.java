package online.noithat.be.repository;


import online.noithat.be.Entity.Product;
import online.noithat.be.Entity.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductDetailRepository extends JpaRepository<ProductDetail, Long> {
    List<ProductDetail> findProductDetailsByIdNotNull();
    ProductDetail findProductDetailById(Long id);

//    List<ProductDetail> findProductDetailsByProductContaining(Product product);
}
