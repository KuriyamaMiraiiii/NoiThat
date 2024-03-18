package online.noithat.be.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import online.noithat.be.enums.Unit;

import java.util.List;

@Entity
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String name;
    Unit unit;

    float pricePerUnit;
    float pricePerAmount;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    List<Resource> resources;

    boolean isDeleted = false;
    @Column(nullable = true)
    float length = 0;
    @Column(nullable = true)
    float width = 0;
    @Column(nullable = true)
    float height = 0;

    @ManyToMany
    List<Category> productCategories;

    @OneToMany(mappedBy = "product" , cascade = CascadeType.ALL)
    List<ProductDetail> productDetails;

    @OneToMany(mappedBy = "product" , cascade = CascadeType.ALL)
    List<ProductColor> productColors;

    @OneToMany(mappedBy = "product" , cascade = CascadeType.ALL)
    List<ProductMaterial> productMaterials;

    @OneToMany(mappedBy = "product" , cascade = CascadeType.ALL)
    @JsonIgnore
    List<QuotationDetail> quotationDetails;

}
