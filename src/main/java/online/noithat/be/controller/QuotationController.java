package online.noithat.be.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.servlet.http.HttpServletResponse;
import online.noithat.be.Entity.Quotation;
import online.noithat.be.dto.request.QuotationAcceptDTO;
import online.noithat.be.dto.request.QuotationRejectDTO;
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
    @GetMapping("/quotation-request/{id}")
    public  ResponseEntity getQuotationByRequestId(@PathVariable long id){
        List<Quotation> quotations = quotationService.getQuotationByRequestId(id);
        return ResponseEntity.ok(quotations);
    }

    @PatchMapping("/accept-quotation")
    public ResponseEntity acceptQuotation(@RequestBody QuotationAcceptDTO quotationAcceptDTO){
        return ResponseEntity.ok(quotationService.acceptQuotation(quotationAcceptDTO));
    }

    @PatchMapping("/reject-quotation")
    public ResponseEntity rejectQuotation(@RequestBody QuotationRejectDTO quotationRejectDTO){
        return ResponseEntity.ok(quotationService.rejectQuotation(quotationRejectDTO));
    }

    @GetMapping("/export-quotation/{quotationId}")
    public void exportQuotation(@PathVariable long quotationId, HttpServletResponse response){
        try{
            quotationService.exportToExcel(quotationId, response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @PostMapping("buy-available")
    public ResponseEntity buyAvailable(@RequestBody QuotationRequestDTO quotationRequestDTO){
        return ResponseEntity.ok(quotationService.buyAvailable(quotationRequestDTO));
    }

    @GetMapping("history-buy-available")
    public ResponseEntity getHistory(){
        return ResponseEntity.ok(quotationService.getAvailableHistory());
    }
}
