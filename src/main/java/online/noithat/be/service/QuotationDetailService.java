package online.noithat.be.service;

import online.noithat.be.Entity.ProductDetail;
import online.noithat.be.Entity.Quotation;
import online.noithat.be.Entity.QuotationDetail;
import online.noithat.be.repository.ProductDetailRepository;
import online.noithat.be.repository.QuotationDetailRepository;
import online.noithat.be.repository.QuotationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuotationDetailService {
    @Autowired
    QuotationDetailRepository quotationDetailRepository;
    @Autowired
    QuotationRepository quotationRepository;
    @Autowired
    ProductDetailRepository productDetailRepository;
    public List<QuotationDetail> getAllQuotationDetails(){
        List<QuotationDetail> quotationDetails = quotationDetailRepository.findQuotationDetailsByIdNotNull();
        return quotationDetails;
    }

    public QuotationDetail getQuotationDetailById(long id){
        QuotationDetail quotationDetail = quotationDetailRepository.findQuotationDetailById(id);
        return quotationDetail;
    }

    public QuotationDetail createQuotationDetail(QuotationDetail quotationDetail){
        Quotation quotation = quotationRepository.findQuotationById(quotationDetail.getId());
        ProductDetail productDetail = productDetailRepository.findProductDetailById(quotationDetail.getId());
        QuotationDetail quotationDetail1 = new QuotationDetail();
        quotationDetail1.setQuotation(quotation);
        quotationDetail1.setProductDetail(productDetail);
        return quotationDetailRepository.save(quotationDetail);
    }
}
