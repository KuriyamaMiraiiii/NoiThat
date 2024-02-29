package online.noithat.be.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String name;
    float price;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    List<Resource> resources;

    boolean isDeleted = false;

    @ManyToMany
    List<Category> productCategories;

    @OneToMany(mappedBy = "product" , cascade = CascadeType.ALL)
    @JsonIgnore
    List<ProductDetail> productDetails;

}
