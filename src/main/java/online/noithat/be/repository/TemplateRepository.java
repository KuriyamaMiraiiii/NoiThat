package online.noithat.be.repository;

import online.noithat.be.Entity.ProductDetail;
import online.noithat.be.Entity.Template;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TemplateRepository extends JpaRepository<Template, Long> {
    List<Template> findTemplatesByIdNotNull();
    Template findTemplateById(long id);
}
