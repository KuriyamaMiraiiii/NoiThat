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
    String img;

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    List<Resource> resources;
    boolean isDeleted = false;

    @ManyToMany
    List<Category> productCategories;
    @OneToMany(mappedBy = "product")
    @JsonIgnore
    List<QuotationDetail> quotationDetails;

}
