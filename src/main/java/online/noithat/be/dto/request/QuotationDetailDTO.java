package online.noithat.be.dto.request;

import lombok.Data;

@Data
public class QuotationDetailDTO {
    long productDetailId;
    long quantity;
    float price;
}
