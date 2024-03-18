package online.noithat.be.repository;

import online.noithat.be.Entity.Account;
import online.noithat.be.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByUsername(String username);
    Account findAccountById(Long id);

    Account findAccountByRole(Role role);

    List<Account> findAccountsByIdNotNull();

    Account findAccountByEmail(String email);
}
