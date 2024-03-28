package online.noithat.be.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;


@Entity
@Getter
@Setter
public class Template {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String name;
    Date datePost;
    @Column(nullable = true)
    String thumbnail;
    boolean isDeleted = false;

    @OneToMany(mappedBy = "template",cascade =  CascadeType.ALL)

    List<TemplateSection> templateSections;

    @OneToMany(mappedBy = "template", cascade = CascadeType.ALL)
    List<ProductDetail> productDetails;

    @ManyToOne
    @JoinColumn(name = "project_type_id")
    ProjectType projectType;




}
