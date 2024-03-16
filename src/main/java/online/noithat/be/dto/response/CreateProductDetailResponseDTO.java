package online.noithat.be.dto.response;

import lombok.Data;
import online.noithat.be.Entity.ProductTemplate;
import online.noithat.be.dto.request.ResourceDTO;
import online.noithat.be.dto.request.TemplateDTO;

import java.util.List;

@Data
public class CreateProductDetailResponseDTO {
    Long materialId;

    Long colorId;

    String name;
    List<ResourceDTO> resourceDTOS;

    long productId;

    float price;
    float length;
    float width;

    float weight;

    float height;
}
