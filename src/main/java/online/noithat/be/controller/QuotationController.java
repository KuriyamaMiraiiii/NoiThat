package online.noithat.be.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import online.noithat.be.Entity.Quotation;
import online.noithat.be.dto.request.QuotationRequestDTO;
import online.noithat.be.service.QuotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@SecurityRequirement(name = "api")
public class QuotationController {
    @Autowired
    QuotationService quotationService;

    @PostMapping("/quotation")
    public ResponseEntity createQuotation(@RequestBody QuotationRequestDTO quotationRequestDTO){
        Quotation quotation = quotationService.createQuotation(quotationRequestDTO);
        return ResponseEntity.ok(quotation);
    }

    @PutMapping("/quotation/{id}")
    public ResponseEntity update(@PathVariable long id, @RequestBody QuotationRequestDTO quotationRequestDTO){
        return  ResponseEntity.ok(quotationService.updateQuotation(id, quotationRequestDTO));
    }

    @GetMapping("/quotation")
    public  ResponseEntity getAllQuotation(){
        List<Quotation> quotations = quotationService.getAllQuotation();
        return  ResponseEntity.ok(quotations);
    }

    @GetMapping("/quotation/{id}")
    public  ResponseEntity getQuotationById(@PathVariable long id){
        Quotation quotation = quotationService.getQuotationById(id);
        return ResponseEntity.ok(quotation);
    }
}
