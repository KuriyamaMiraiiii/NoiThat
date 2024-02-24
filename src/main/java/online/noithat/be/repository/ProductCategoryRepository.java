package online.noithat.be.repository;

import online.noithat.be.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductCategoryRepository extends JpaRepository<Category, Long> {
    Category findProductCategoryById(long id);
    List<Category> findProductCategoriesByIdNotNull();


}
