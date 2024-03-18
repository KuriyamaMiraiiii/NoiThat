package online.noithat.be.dto.request;

import lombok.Data;
import online.noithat.be.Entity.Resource;

import java.util.Date;
import java.util.List;

@Data
public class BlogRequestDTO {
    String blogName;
    Date datePost;
    String thumbnail;
    List<BlogSectionRequestDTO> blogSectionRequestDTOS;
}
