package ru.crm.portfolio.crmportfolioexample.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.crm.portfolio.crmportfolioexample.dto.AccountDto;
import ru.crm.portfolio.crmportfolioexample.dto.ClientDto;
import ru.crm.portfolio.crmportfolioexample.models.Account;
import ru.crm.portfolio.crmportfolioexample.models.Client;
import ru.crm.portfolio.crmportfolioexample.repositories.AccountRepositories;
import ru.crm.portfolio.crmportfolioexample.repositories.ClientRepositories;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepositories accountsRepository;

    private final ClientRepositories clientRepositories;

    @Override
    public List<AccountDto> getAllUsers() {
        return AccountDto.from(accountsRepository.findAllByState(Account.State.WORKING));
    }

    @Override
    public List<AccountDto> findAllUserState() {
        return AccountDto.from(accountsRepository.findAllByRole(new Account().getRole().SALES_MANAGER));
    }

    @Override
    public void deleteUser(Long userId) {
        Account account = accountsRepository.getById(userId);
        account.setState(Account.State.FIRED);
        accountsRepository.save(account);
    }

    @Override
    public void addAccount(AccountDto accountDto) {
        Account newAccount = Account.builder()
                .email(accountDto.getEmail())
                .firstName(accountDto.getFirstName())
                .lastName(accountDto.getLastName())
                .numberTel(accountDto.getNumberTel())
                .hashPassword(accountDto.getPassword())
                .role(accountDto.getRole())
                .state(Account.State.WORKING)
                .build();
        accountsRepository.save(newAccount);
    }

    @Override
    public void addClientToUser(Long id, ClientDto clientDto) {
        Account account = accountsRepository.getById(id);
        Client client = clientRepositories.getById(clientDto.getId());
        client.setAccount(account);
        clientRepositories.save(client);
    }

    @Override
    public void updateSalesPlan(Long id,AccountDto accountDto) {
        Account account = accountsRepository.getById(id);
        account.setSalesPlan(accountDto.getSalesPlan());
        accountsRepository.save(account);
    }
}
