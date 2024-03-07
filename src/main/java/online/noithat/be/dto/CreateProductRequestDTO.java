package online.noithat.be.dto;

import lombok.Data;
import online.noithat.be.Entity.ProductColor;
import online.noithat.be.Entity.Resource;
import online.noithat.be.dto.request.ResourceDTO;

import java.util.List;
@Data
public class CreateProductRequestDTO {
    String name;
    List<Long> categoriesId;

    float price;

    List<ResourceDTO> resourceDTOS;

    List<ProductColor> productColors;
}
