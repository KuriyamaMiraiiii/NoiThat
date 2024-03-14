package online.noithat.be.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import online.noithat.be.enums.QuotationType;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Quotation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;
    Date created;
    @ManyToOne
    @JoinColumn(name = "request_id")
    Request request;
    @OneToMany(mappedBy = "quotation", cascade = CascadeType.ALL)
    List<QuotationDetail> quotationDetails;
    @Enumerated(EnumType.STRING)
    QuotationType type;

    String reasonReject;
}
