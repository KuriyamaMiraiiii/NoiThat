package online.noithat.be.dto.request;

import jakarta.persistence.Column;
import lombok.Data;
import online.noithat.be.Entity.ProductDetail;
import online.noithat.be.Entity.ProjectType;
import online.noithat.be.Entity.TemplateSection;

import java.util.Date;
import java.util.List;

@Data
public class TemplateDTO {
    Long projectTypeId;
    String name;

    String thumbnail;
    Date datePost;
    List<TemplateSectionDTO> templateSectionDTOS;
    List<ProductDetail> productDetails;

}
