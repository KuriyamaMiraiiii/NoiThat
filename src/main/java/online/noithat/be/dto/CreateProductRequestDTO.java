package online.noithat.be.dto;

import lombok.Data;
import online.noithat.be.Entity.ProductColor;
import online.noithat.be.Entity.Resource;
import online.noithat.be.dto.request.ResourceDTO;
import online.noithat.be.enums.Unit;

import java.util.List;
@Data
public class CreateProductRequestDTO {
    String name;
    List<Long> categoriesId;

    Unit unit;

    float pricePerUnit;
    float pricePerAmount;

    List<ResourceDTO> resourceDTOS;

    List<ProductColor> productColors;

}
