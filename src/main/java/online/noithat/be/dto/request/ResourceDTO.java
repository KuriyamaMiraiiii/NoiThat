package online.noithat.be.dto.request;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import online.noithat.be.enums.ResourceType;

@Data
public class ResourceDTO {
    String url;
    @Enumerated(EnumType.STRING)
    ResourceType type;
}
