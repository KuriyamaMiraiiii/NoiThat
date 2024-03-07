package online.noithat.be.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String name;
    @ManyToMany
    @JsonIgnore
    List<Product> products;
    boolean isDeleted = false;

    @ManyToMany
    @JoinTable(
            name = "projectType",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "project_type_id"))
    List<ProjectType> projectTypes;

}
