package online.noithat.be.dto.request;

import jakarta.persistence.*;
import lombok.Data;
import online.noithat.be.Entity.QuotationDetail;
import online.noithat.be.Entity.Request;
import online.noithat.be.enums.QuotationType;

import java.util.Date;
import java.util.List;

@Data
public class QuotationRequestDTO {

    Long requestId;
    @Enumerated(EnumType.STRING)
    QuotationType type;
    List<QuotationDetailDTO> quotationDetailDTOS;

}
