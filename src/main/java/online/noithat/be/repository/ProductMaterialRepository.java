package online.noithat.be.repository;

import online.noithat.be.Entity.Product;
import online.noithat.be.Entity.ProductColor;
import online.noithat.be.Entity.ProductMaterial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductMaterialRepository extends JpaRepository<ProductMaterial, Long> {
    List<ProductMaterial> findProductMaterialsByIdNotNull();
    ProductMaterial findProductMaterialById(Long id);

    List<ProductMaterial> findProductMaterialsByProduct(Product product);
}
