package online.noithat.be.dto.request;

import lombok.Data;
import online.noithat.be.Entity.Resource;

import java.util.List;

@Data
public class ProductRequestDTO {
    String name;
    float price;
    List<Resource> resourceList;
}
