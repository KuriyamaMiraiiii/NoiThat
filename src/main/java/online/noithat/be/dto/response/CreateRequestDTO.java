package online.noithat.be.dto.response;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import online.noithat.be.dto.request.ResourceDTO;
import online.noithat.be.enums.RequestType;

import java.util.List;

@Data
public class CreateRequestDTO {

    @Enumerated(EnumType.STRING)
    RequestType type;
    long bugget;
    String description;
    String dienTich;

    List<ResourceDTO> resourceDTOS;
}
