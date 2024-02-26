package online.noithat.be.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class ProductMaterial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String size;
    boolean isDeleted = false;

    @OneToMany(mappedBy = "material")
    @JsonIgnore
    List<ProductDetail> productDetails;
}
