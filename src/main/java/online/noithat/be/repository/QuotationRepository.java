package online.noithat.be.repository;

import online.noithat.be.Entity.ProductDetail;
import online.noithat.be.Entity.Quotation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuotationRepository extends JpaRepository<Quotation,Long> {
    List<Quotation> findQuotationsByIdNotNull();
    Quotation findQuotationById(Long id);
}
