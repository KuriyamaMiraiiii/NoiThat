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

    @ManyToMany
    @JoinTable(
            name = "template_product-detail",
            joinColumns = @JoinColumn(name = "product_detail_id"),
            inverseJoinColumns = @JoinColumn(name = "template_id"))
    List<ProductTemplate> templates;

    @ManyToOne
    @JoinColumn(name = "material_id")
    ProductMaterial material;

    @ManyToOne
    @JoinColumn(name = "color_id")
    ProductColor color;

}
