package online.noithat.be.service;

import online.noithat.be.Entity.ProductDetail;
import online.noithat.be.Entity.Quotation;
import online.noithat.be.Entity.QuotationDetail;
import online.noithat.be.dto.request.QuotationDetailRequestDTO;
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

//    public QuotationDetail createQuotationDetail(QuotationDetailRequestDTO quotationDetailRequestDTO){
//        for (Long productDetaislId : quotationDetailRequestDTO.getProductDetailsId()){
//            QuotationDetail quotationDetail = new QuotationDetail();
//            ProductDetail productDetail = productDetailRepository.findProductDetailById(productDetaislId);
//            quotationDetail.setProductDetail(productDetail);
//            quotationDetail.setQuotation(productDetail);
//            quotationDetails.add(quotationDetail);
//        }
//    }
}
