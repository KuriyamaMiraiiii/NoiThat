package online.noithat.be.service;

import online.noithat.be.Entity.ProductDetail;
import online.noithat.be.Entity.Quotation;
import online.noithat.be.repository.QuotationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuotationService {
    @Autowired
    QuotationRepository quotationRepository;

    public List<Quotation> getAllQuotation(){
        List<Quotation> quotations = quotationRepository.findQuotationsByIdNotNull();
        return quotations;
    }

//    public ProductDetail getProductDetailById(long id){
//        ProductDetail productDetail = productDetailRepository.findProductDetailById(id);
//        return productDetail;
//    }
}
