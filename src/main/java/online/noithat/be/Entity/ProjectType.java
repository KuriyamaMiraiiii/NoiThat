package online.noithat.be.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import online.noithat.be.enums.ResourceType;

import java.util.List;

@Data
@Entity
public class ProjectType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String name;
    boolean isDeleted = false;
    @Enumerated(EnumType.STRING)
    ResourceType resourceType;

    @ManyToMany
    @JoinTable(
            name = "category",
            joinColumns = @JoinColumn(name = "project_type_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    List<Category> categoryList;

    @ManyToMany
    @JoinTable(
            name = "template_product_detail",
            joinColumns = @JoinColumn(name = "project_type_id"),
            inverseJoinColumns = @JoinColumn(name = "template_id"))
    List<ProductTemplate> productTemplates;

    @OneToMany(mappedBy = "projectType",cascade = CascadeType.ALL)
    @JsonIgnore
    List<Resource>resources;


}
