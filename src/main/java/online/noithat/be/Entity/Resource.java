package online.noithat.be.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
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
    BlogSection blogSection;

    @ManyToOne
    @JoinColumn(name = "product_detail_id")
    ProductDetail productDetail;

    @ManyToOne
    @JoinColumn(name = "request_id")
    @JsonIgnore
    Request request;

    @ManyToOne
    @JoinColumn(name = "project_type_id")
    @JsonIgnore
    ProjectType projectType;
}
