package online.noithat.be.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
<<<<<<< Updated upstream
import com.fasterxml.jackson.annotation.JsonSubTypes;
=======
>>>>>>> Stashed changes
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import online.noithat.be.enums.ResourceType;
import org.hibernate.annotations.Type;

@Entity
@Getter
@Setter

public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Enumerated(EnumType.STRING)
    ResourceType type;
    String url;


    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonIgnore
    Product product;

    @ManyToOne
    @JoinColumn(name = "blog_id")
    @JsonIgnore
    Blog blog;

    @ManyToOne
    @JoinColumn(name = "product_detail_id")
    ProductDetail productDetail;

<<<<<<< Updated upstream
=======
    @ManyToOne
    @JoinColumn(name = "request_id")
    Request request;
>>>>>>> Stashed changes
}
