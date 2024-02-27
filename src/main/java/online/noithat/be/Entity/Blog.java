package online.noithat.be.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String blogName;
    Date datePost;
    boolean isDeleted = false;

    @OneToMany(mappedBy = "blog", cascade = CascadeType.ALL)
            @JsonIgnore
    List<Resource> resources;

    @ManyToOne
    @JoinColumn(name = "account_id")
    Account account;
}
