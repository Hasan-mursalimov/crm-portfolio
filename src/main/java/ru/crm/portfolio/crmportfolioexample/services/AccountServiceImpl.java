package ru.crm.portfolio.crmportfolioexample.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.crm.portfolio.crmportfolioexample.dto.AccountDto;
import ru.crm.portfolio.crmportfolioexample.models.Account;
import ru.crm.portfolio.crmportfolioexample.repositories.AccountRepositories;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepositories accountsRepository;

    @Override
    public List<AccountDto> getAllUsers() {
        return AccountDto.from(accountsRepository.findAllByState(Account.State.WORKING));
    }

    @Override
    public void deleteUser(Long userId) {
        Account account = accountsRepository.getById(userId);
        account.setState(Account.State.FIRED);
        accountsRepository.save(account);
    }
}
