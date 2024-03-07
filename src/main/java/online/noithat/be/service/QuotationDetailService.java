package online.noithat.be.service;

import online.noithat.be.Entity.ProductDetail;
import online.noithat.be.Entity.Quotation;
import online.noithat.be.Entity.QuotationDetail;
import online.noithat.be.dto.request.QuotationDetailDTO;
import online.noithat.be.dto.request.QuotationDetailRequestDTO;
import online.noithat.be.dto.request.QuotationRequestDTO;
import online.noithat.be.repository.ProductDetailRepository;
import online.noithat.be.repository.QuotationDetailRepository;
import online.noithat.be.repository.QuotationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
//        QuotationDetail quotationDetail = new QuotationDetail();
//        for (Long productDetaislId : quotationDetailRequestDTO.getProductDetailsId()){
//
//            ProductDetail productDetail = productDetailRepository.findProductDetailById(productDetaislId);
//            Quotation quotation = quotationRepository.findQuotationById(quotationDetailRequestDTO.getQuotationId());
//            quotationDetail.setProductDetail(productDetail);
//            quotationDetail.setQuotation(quotation);
////            quotationDetail.setQuantity(quotationDetailRequestDTO.getQuantity());
////            quotationDetail.setPrice(quotationDetailRequestDTO.getPrice());
//            List<QuotationDetail> quotationDetails = new ArrayList<>();
//            for(QuotationRequestDTO quotationRequestDTO : quotationDetailRequestDTO.getQuotationRequestDTOS()){
//
//                for(QuotationDetailDTO quotationDetailDTO : quotationRequestDTO.getQuotationDetailDTOS()){
//                    quotationDetail.setQuantity(quotationDetailDTO.getQuantity());
//                    quotationDetail.setLength(quotationDetailDTO.getLength());
//                    quotationDetail.setWidth(quotationDetailDTO.getWidth());
//                    quotationDetail.setPrice(quotationDetailDTO.getPrice());
//                    quotationDetail.setPricePerUnit(quotationDetailDTO.getPricePerUnit());
//                    quotationDetail.setTotal(quotationDetailDTO.getTotal());
//                    quotationDetail.setUnit(quotationDetailDTO.getUnit());
//
//
//                }
//            }
//
//        }
//
//        return null;
//    }
}
