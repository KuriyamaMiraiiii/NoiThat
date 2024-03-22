package online.noithat.be.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import online.noithat.be.enums.ProjectEnumType;
import online.noithat.be.enums.ResourceType;

import java.util.List;

@Data
@Entity
public class ProjectType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    boolean isDeleted = false;
    @Enumerated(EnumType.STRING)
    ProjectEnumType type;

    @ManyToMany(mappedBy = "projectTypes",cascade = CascadeType.ALL)
    List<Category> categoryList;

    @ManyToMany
    @JsonIgnore
    @JoinTable(
            name = "template_product_detail",
            joinColumns = @JoinColumn(name = "project_type_id"),
            inverseJoinColumns = @JoinColumn(name = "template_id"))
    List<ProductTemplate> productTemplates;

    @OneToMany(mappedBy = "projectType",cascade = CascadeType.ALL)
    @JsonIgnore
    List<Resource>resources;

    @OneToMany(mappedBy = "projectType",cascade = CascadeType.ALL)
    @JsonIgnore
    List<Template>templates;
}
