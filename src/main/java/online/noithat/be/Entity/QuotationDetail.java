package online.noithat.be.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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
    @JoinColumn(name = "quotation_id")
    @JsonIgnore
    Quotation quotation;

    long quantity;
    Float price;

}
