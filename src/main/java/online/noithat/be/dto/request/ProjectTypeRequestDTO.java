package online.noithat.be.dto.request;

import lombok.Data;

import java.util.List;
@Data
public class ProjectTypeRequestDTO {
    String type;
    List<ResourceDTO> resourceDTOList;
}
