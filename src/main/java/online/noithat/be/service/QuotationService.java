package online.noithat.be.service;

import online.noithat.be.Entity.ProductDetail;
import online.noithat.be.Entity.Quotation;
import online.noithat.be.Entity.QuotationDetail;
import online.noithat.be.Entity.Request;
import online.noithat.be.dto.request.QuotationDetailDTO;
import online.noithat.be.dto.request.QuotationRequestDTO;
import online.noithat.be.dto.response.CreateRequestDTO;
import online.noithat.be.repository.ProductDetailRepository;
import online.noithat.be.repository.QuotationRepository;
import online.noithat.be.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class QuotationService {
    @Autowired
    QuotationRepository quotationRepository;
    @Autowired
    RequestRepository requestRepository;
    @Autowired
    ProductDetailRepository productDetailRepository;

    public List<Quotation> getAllQuotation(){
        List<Quotation> quotations = quotationRepository.findQuotationsByIdNotNull();
        return quotations;
    }

    public  Quotation getQuotationById(long id){
        Quotation quotation = quotationRepository.findQuotationById(id);
        return quotation;
    }
//    public ProductDetail getProductDetailById(long id){
//        ProductDetail productDetail = productDetailRepository.findProductDetailById(id);
//        return productDetail;
//    }

    public Quotation createQuotation (QuotationRequestDTO quotationRequestDTO){
        Request request = requestRepository.findRequestById(quotationRequestDTO.getRequestId());
        Quotation quotation = new Quotation();
        quotation.setRequest(request);
        quotation.setType(quotationRequestDTO.getType());
        quotation.setCreated(new Date());
        List<QuotationDetail> quotationDetails = new ArrayList<>();
        for (QuotationDetailDTO quotationDetailDTO : quotationRequestDTO.getQuotationDetailDTOS()){
            QuotationDetail quotationDetail = new QuotationDetail();
            ProductDetail productDetail = productDetailRepository.findProductDetailById(quotationDetailDTO.getProductDetailId());
            quotationDetail.setProductDetail(productDetail);
            quotationDetail.setQuotation(quotation);
            quotationDetail.setQuantity(quotationDetailDTO.getQuantity());
            quotationDetail.setPrice(quotationDetailDTO.getPrice());
            quotationDetail.setLength(quotationDetailDTO.getLength());
            quotationDetail.setWidth(quotationDetailDTO.getWidth());
            quotationDetail.setPricePerUnit(quotationDetailDTO.getPricePerUnit());
            quotationDetail.setTotal(quotationDetailDTO.getTotal());

            quotationDetails.add(quotationDetail);
        }
        quotation.setQuotationDetails(quotationDetails);

        return quotationRepository.save(quotation);
    }

    public Quotation updateQuotation(long id, QuotationRequestDTO quotationRequestDTO){

        Request request = requestRepository.findRequestById(quotationRequestDTO.getRequestId());
        Quotation quotation = quotationRepository.findQuotationById(id);
        quotation.setRequest(request);
        quotation.setType(quotationRequestDTO.getType());
        return quotationRepository.save(quotation);
    }



}
