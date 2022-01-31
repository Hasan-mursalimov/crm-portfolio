package ru.crm.portfolio.crmportfolioexample.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.crm.portfolio.crmportfolioexample.models.Account;

import java.util.List;
import java.util.Optional;

public interface AccountRepositories extends JpaRepository<Account, Long> {

    Optional<Account> findByEmail(String email);

    List<Account> findAllByState(Account.State state);

}
