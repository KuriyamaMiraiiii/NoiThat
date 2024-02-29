package online.noithat.be.service;

import online.noithat.be.Entity.ProductDetail;
import online.noithat.be.Entity.Quotation;
import online.noithat.be.Entity.QuotationDetail;
import online.noithat.be.Entity.Request;
import online.noithat.be.dto.request.QuotationRequestDTO;
import online.noithat.be.dto.response.CreateRequestDTO;
import online.noithat.be.repository.QuotationRepository;
import online.noithat.be.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuotationService {
    @Autowired
    QuotationRepository quotationRepository;
    @Autowired
    RequestRepository requestRepository;

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
        quotation.setCreated(quotationRequestDTO.getCreated());
        quotation.setRequest(request);
        quotation.setType(quotationRequestDTO.getType());

        return quotationRepository.save(quotation);
    }

    public Quotation updateQuotation(long id, QuotationRequestDTO quotationRequestDTO){

        Request request = requestRepository.findRequestById(quotationRequestDTO.getRequestId());
        Quotation quotation = quotationRepository.findQuotationById(id);
        quotation.setCreated(quotationRequestDTO.getCreated());
        quotation.setRequest(request);
        quotation.setType(quotationRequestDTO.getType());
        return quotationRepository.save(quotation);
    }



}
