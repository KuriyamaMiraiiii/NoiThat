package online.noithat.be.dto.request;

import lombok.Data;

@Data
public class QuotationRejectDTO {
    long quotationId;
    String reasonReject;
}
