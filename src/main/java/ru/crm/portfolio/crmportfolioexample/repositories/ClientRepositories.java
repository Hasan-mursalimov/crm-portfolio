package ru.crm.portfolio.crmportfolioexample.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.crm.portfolio.crmportfolioexample.models.Client;

import java.util.List;

public interface ClientRepositories extends JpaRepository<Client, Long> {
    List<Client> findAllByAccount_id(Long accountId);

    List<Client> findAllByAccountIsNull();

    List<Client> findAllByRegistrationTern(Client.RegistrationTern tern);

    List<Client> findAllByPurchaseVolumes(Client.PurchaseVolumes volumes);

    List<Client> findAllByState(Client.State state);
}
