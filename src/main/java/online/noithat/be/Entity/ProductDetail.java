package online.noithat.be.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class ProductDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @OneToMany(mappedBy = "productDetail")
    @JsonIgnore
    List<Resource> resources;

    @ManyToOne
    List<ProductTemplate> productTemplates;

    @ManyToOne
    List<ProductMaterial> productMaterials;

    @ManyToOne
    List<ProductColor> productColors;

}
