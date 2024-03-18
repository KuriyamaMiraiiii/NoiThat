package online.noithat.be.dto.request;

import lombok.Data;

import java.util.List;
@Data
public class TemplateSectionDTO {
    String name;
    String img;
    List<ResourceDTO> resourceDTOS;
}
