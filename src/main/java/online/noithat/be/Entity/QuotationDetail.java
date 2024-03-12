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
public class QuotationDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;
    @ManyToOne
    @JoinColumn(name = "product_detail_id")
    ProductDetail productDetail;

    @ManyToOne
    @JoinColumn(name = "product_id")
    Product product;

    @ManyToOne
    @JoinColumn(name = "quotation_id")
    @JsonIgnore
    Quotation quotation;

    long quantity;

    float length;
    float width;
    float weight;
    @Column(nullable = true)
    float height;
    Unit unit;
    float pricePerUnit;
    float total;

}
