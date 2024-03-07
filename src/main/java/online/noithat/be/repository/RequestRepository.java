package online.noithat.be.repository;

import online.noithat.be.Entity.Account;
import online.noithat.be.Entity.Quotation;
import online.noithat.be.Entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequestRepository extends JpaRepository<Request, Long> {
    List<Request> findRequestsByIdNotNull();
    Request findRequestById(Long id);

    List<Request> findRequestsByAccount(Account account);
}
