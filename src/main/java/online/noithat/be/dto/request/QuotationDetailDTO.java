package online.noithat.be.dto.request;

import lombok.Data;
import online.noithat.be.enums.Unit;

@Data
public class QuotationDetailDTO {
    long productDetailId;
    long productId;
    long quantity;

    float height;
    float length;
    float width;
    float weight;
    float pricePerUnit;
    float total;
    Unit unit;
}
