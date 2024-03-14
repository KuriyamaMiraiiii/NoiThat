package online.noithat.be.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class BlogSection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String name;

    @ManyToOne()
    @JoinColumn(name = "blog_id")
    @JsonIgnore
    Blog blog;

    @OneToMany(mappedBy = "blogSection", cascade = CascadeType.ALL)
    List<Resource> resources;
}
