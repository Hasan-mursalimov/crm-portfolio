package ru.crm.portfolio.crmportfolioexample.services;

import ru.crm.portfolio.crmportfolioexample.dto.AccountDto;
import ru.crm.portfolio.crmportfolioexample.dto.ClientDto;

import java.util.List;

public interface SearchService {

    List<AccountDto> searchAccount(String email, String lastName, String firstName, String numberTel);

    List<ClientDto> searchClient(String lastName, String firstName, String tradeName, String inn);
}
