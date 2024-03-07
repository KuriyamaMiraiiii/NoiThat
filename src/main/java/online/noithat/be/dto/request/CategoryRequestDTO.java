package online.noithat.be.dto.request;

import lombok.Data;
import online.noithat.be.Entity.ProjectType;

import java.util.List;

@Data
public class CategoryRequestDTO {
    String name;
    List<ProjectTypeRequestDTO> projectTypeRequestDTOS;
}
