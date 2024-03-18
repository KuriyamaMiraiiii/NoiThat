package online.noithat.be.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import online.noithat.be.enums.BlogStatus;

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
//    BlogStatus status = BlogStatus.INACTIVE;

    @Column(nullable = true)
    String thumbnail;

    @OneToMany(mappedBy = "blog", cascade = CascadeType.ALL)
    List<BlogSection> blogSections;

    @ManyToOne
    @JoinColumn(name = "account_id")
    Account account;
}
