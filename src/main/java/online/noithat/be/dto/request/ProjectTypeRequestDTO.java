package online.noithat.be.dto.request;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import online.noithat.be.Entity.Category;
import online.noithat.be.enums.ProjectEnumType;

import java.util.List;
@Data
public class ProjectTypeRequestDTO {
    long id;
    @Enumerated(EnumType.STRING)
    ProjectEnumType type;
    List<ResourceDTO> resourceDTOList;
    List<Long> categoriesId;
}
