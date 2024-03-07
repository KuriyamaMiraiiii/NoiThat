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
    float price = 0;
    Unit unit;

    float pricePerUnit;
    float pricePerAmount;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    List<Resource> resources;

    boolean isDeleted = false;

    @ManyToMany
    List<Category> productCategories;

    @OneToMany(mappedBy = "product" , cascade = CascadeType.ALL)
    List<ProductDetail> productDetails;

    @OneToMany(mappedBy = "product" , cascade = CascadeType.ALL)
    List<ProductColor> productColors;

}
