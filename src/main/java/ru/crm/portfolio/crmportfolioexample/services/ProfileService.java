package ru.crm.portfolio.crmportfolioexample.services;

import ru.crm.portfolio.crmportfolioexample.dto.AccountDto;
import ru.crm.portfolio.crmportfolioexample.dto.ClientDto;

import java.util.List;

public interface ProfileService {

    AccountDto getUser(Long userId);

    List<ClientDto> getClientByUser(Long userId);

    ClientDto deleteClient(Long userId);
}
