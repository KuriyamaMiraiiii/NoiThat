package online.noithat.be.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import online.noithat.be.Entity.QuotationDetail;
import online.noithat.be.service.QuotationDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@SecurityRequirement(name = "api")
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
