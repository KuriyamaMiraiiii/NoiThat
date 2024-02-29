package online.noithat.be.repository;

import online.noithat.be.Entity.Quotation;
import online.noithat.be.Entity.QuotationDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuotationDetailRepository extends JpaRepository<QuotationDetail, Long> {
    List<QuotationDetail> findQuotationDetailsByIdNotNull();
    QuotationDetail findQuotationDetailById(long id);

}
