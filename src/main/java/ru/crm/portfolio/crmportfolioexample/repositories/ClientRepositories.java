package ru.crm.portfolio.crmportfolioexample.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.crm.portfolio.crmportfolioexample.models.Client;

import java.util.List;

public interface ClientRepositories extends JpaRepository<Client, Long> {


}
