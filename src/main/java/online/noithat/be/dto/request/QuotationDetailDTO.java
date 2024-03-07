package online.noithat.be.dto.request;

import lombok.Data;
import online.noithat.be.enums.Unit;

@Data
public class QuotationDetailDTO {
    long productDetailId;
    long productId;
    long quantity;
    float price;

    float length;
    float width;
    float pricePerUnit;
    float total;
    Unit unit;
}
