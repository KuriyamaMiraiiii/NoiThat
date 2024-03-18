package online.noithat.be.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import online.noithat.be.dto.request.TemplateDTO;

import java.util.List;

@Entity
@Data
public class TemplateSection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String name;

    @ManyToOne
    @JoinColumn(name = "template_id")
    @JsonIgnore
    Template template;

    @OneToMany(mappedBy = "templateSection", cascade = CascadeType.ALL)
    List<Resource> resources;
}
