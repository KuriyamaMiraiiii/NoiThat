package online.noithat.be.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class BlogSectionRequestDTO {
    String name;
    String img;
    List<ResourceDTO> resourceDTO;
}
