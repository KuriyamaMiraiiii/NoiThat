package online.noithat.be.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class ProductColor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String color;

    boolean isDeleted = false;


    @OneToMany(mappedBy = "color",cascade = CascadeType.ALL)
    @JsonIgnore
    List<ProductDetail> productColors;
}
