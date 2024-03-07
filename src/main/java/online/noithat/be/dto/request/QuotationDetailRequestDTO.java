package online.noithat.be.dto.request;

import lombok.Data;
import online.noithat.be.Entity.Quotation;

import java.util.List;

@Data
public class QuotationDetailRequestDTO {
    long quotationId;
    long quantity;
    float price;
    List<Long> productDetailsId;
    List<QuotationRequestDTO> quotationRequestDTOS;
}
