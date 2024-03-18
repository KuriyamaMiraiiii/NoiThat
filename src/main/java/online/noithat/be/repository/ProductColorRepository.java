package online.noithat.be.repository;

import online.noithat.be.Entity.Product;
import online.noithat.be.Entity.ProductColor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductColorRepository extends JpaRepository<ProductColor, Long> {
    List<ProductColor> findProductColorsByIdNotNull();
    ProductColor findProductColorById(Long id);

    List<ProductColor> findProductColorsByProduct(Product product);
}
