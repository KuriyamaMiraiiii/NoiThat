package online.noithat.be.controller;

import online.noithat.be.Entity.QuotationDetail;
import online.noithat.be.service.QuotationDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


public class QuotationDetailController {
    @Autowired
    QuotationDetailService quotationDetailService;

    @GetMapping("/quotationDetail")
    public ResponseEntity getAllQuotationDetails(){
        List<QuotationDetail> quotationDetails = quotationDetailService.getAllQuotationDetails();
        return ResponseEntity.ok(quotationDetails);
    }

    @GetMapping("/quotationDetail/{id}")
    public ResponseEntity getQuotationDetailById(@PathVariable long id){
        QuotationDetail quotationDetails = quotationDetailService.getQuotationDetailById(id);
        return ResponseEntity.ok(quotationDetails);
    }
    
}
