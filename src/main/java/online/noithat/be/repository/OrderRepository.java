package online.noithat.be.repository;

import online.noithat.be.Entity.Quotation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Quotation, Long> {
}
