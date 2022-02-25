package ru.crm.portfolio.crmportfolioexample.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.crm.portfolio.crmportfolioexample.models.Account;
import ru.crm.portfolio.crmportfolioexample.repositories.AccountRepositories;

import java.util.Optional;


@RequiredArgsConstructor
@Service
public class ConfirmServiceImpl implements ConfirmService {

    private final AccountRepositories accountsRepository;

    @Override
    public boolean confirm(String uuid) {
        Optional<Account> account = accountsRepository.findByConfirmUUID(uuid);
        if (account.isPresent()) {
            Account forSave = account.get();
            forSave.setState(Account.State.WORKING);
            accountsRepository.save(forSave);
            return true;
        }
        return false;
    }

}
