package online.noithat.be.dto.response;

import lombok.Data;
import online.noithat.be.enums.Unit;

@Data
public class ProductResponseDTO {
    String name;
    float length;
    float width;
    float weight;
    Unit unit;
    float pricePerUnit;
    float total;
    String image;
}
