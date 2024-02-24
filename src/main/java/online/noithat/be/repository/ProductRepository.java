package online.noithat.be.repository;

import online.noithat.be.Entity.Product;
import online.noithat.be.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findProductsByIdNotNull();
    List<Product> findProductsByProductCategoriesContaining(Category category);

    Product findProductById(Long id);
}
