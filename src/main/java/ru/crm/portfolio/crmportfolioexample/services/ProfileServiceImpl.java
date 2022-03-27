package ru.crm.portfolio.crmportfolioexample.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.crm.portfolio.crmportfolioexample.dto.AccountDto;
import ru.crm.portfolio.crmportfolioexample.dto.ClientDto;
import ru.crm.portfolio.crmportfolioexample.exempions.UserNotFoundException;
import ru.crm.portfolio.crmportfolioexample.models.Account;
import ru.crm.portfolio.crmportfolioexample.models.Client;
import ru.crm.portfolio.crmportfolioexample.repositories.AccountRepositories;
import ru.crm.portfolio.crmportfolioexample.repositories.ClientRepositories;

import java.util.List;

import static ru.crm.portfolio.crmportfolioexample.dto.ClientDto.from;

@RequiredArgsConstructor
@Service
public class ProfileServiceImpl implements ProfileService {

    private final AccountRepositories accountRepositories;

    private final ClientRepositories clientRepositories;

    @Override
    public AccountDto getUser(Long userId) {
        return AccountDto.from(accountRepositories.getById(userId));
    }

    @Override
    public List<ClientDto> getClientByUser(Long userId) {
        accountRepositories.findById(userId).orElseThrow(UserNotFoundException::new);
        return from(clientRepositories.findAllByAccount_id(userId));
    }

    @Override
    public ClientDto deleteClient(Long clientId) {
        Account newAccount = Account.builder()
                .id(null)
                .build();
        Client client = clientRepositories.getById(clientId);
        client.setAccount(newAccount);
        clientRepositories.save(client);
        return ClientDto.from(client);
    }
}
