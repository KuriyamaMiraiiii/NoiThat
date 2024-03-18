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
    @OneToMany(mappedBy = "productDetail", cascade = CascadeType.ALL)
    List<Resource> resources;
    float price;

    @Column(nullable = true)
    float length;
    @Column(nullable = true)
    float width;
    @Column(nullable = true)
    float weight;
    @Column(nullable = true)
    float height;

    String name;
    @ManyToMany
    @JoinTable(
            name = "template_product_detail",
            joinColumns = @JoinColumn(name = "product_detail_id"),
            inverseJoinColumns = @JoinColumn(name = "template_id"))
    List<ProductTemplate> templates;

    @ManyToOne
    @JoinColumn(name = "material_id")
    ProductMaterial material;

    @ManyToOne
    @JoinColumn(name = "color_id")
    ProductColor color;

    boolean isDeleted = false;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonIgnore
    Product product;

    @OneToMany(mappedBy = "productDetail", cascade = CascadeType.ALL)
    @JsonIgnore
    List<QuotationDetail> quotationDetails;

    @ManyToOne
    @JoinColumn(name = "template_id")
    @JsonIgnore
    Template template;
}
