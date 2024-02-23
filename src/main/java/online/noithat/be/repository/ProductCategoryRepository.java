package online.noithat.be.repository;

import online.noithat.be.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductCategoryRepository extends JpaRepository<Category, Long> {
    Category findProductCategoryByProductCategoryId(long id);
    List<Category> findProductCategoriesByProductCategoryIdNotNull();
}
