package online.noithat.be.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String blogName;
    String content;
    Date datePost;

    @ManyToOne
    @JoinColumn(name = "account_id")
    Account account;
}
