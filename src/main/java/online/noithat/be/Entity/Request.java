package online.noithat.be.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import online.noithat.be.enums.RequestType;

import java.util.List;

@Entity
@Getter
@Setter
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @ManyToOne
    @JoinColumn(name = "account_id")
    Account account;

    @Enumerated(EnumType.STRING)
    RequestType type;
    long budget ;
    String description;
    String dienTich;

    @OneToMany(mappedBy = "request", cascade = CascadeType.ALL)

    List<Resource> resources;

    @OneToMany(mappedBy = "request",cascade = CascadeType.ALL)
    @JsonIgnore
    List<Quotation> quotations;

    boolean isDeleted = false;

    @ManyToOne
    @JoinColumn(name = "staff_id")
    @JsonIgnore
    Account staff;
}
