package ru.crm.portfolio.crmportfolioexample.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.crm.portfolio.crmportfolioexample.dto.AccountDto;
import ru.crm.portfolio.crmportfolioexample.dto.ClientDto;
import ru.crm.portfolio.crmportfolioexample.repositories.AccountRepositories;
import ru.crm.portfolio.crmportfolioexample.repositories.ClientRepositories;

import java.util.List;

import static ru.crm.portfolio.crmportfolioexample.dto.AccountDto.from;
import static ru.crm.portfolio.crmportfolioexample.dto.ClientDto.from;

@Service
@RequiredArgsConstructor
public class SearchServiceImpl implements SearchService {

    private final AccountRepositories accountRepositories;

    private final ClientRepositories clientRepositories;

    @Override
    public List<AccountDto> searchAccount(String email, String lastName, String firstName, String numberTel) {
        return from(accountRepositories.findByEmailOrLastNameOrFirstNameOrNumberTel("%" + email + "%", "%" + lastName + "%", "%" + firstName + "%", "%" + numberTel + "%"));
    }

    @Override
    public List<ClientDto> searchClient(String lastName, String firstName, String tradeName, String inn) {
        return from(clientRepositories.findByLastNameAndFirstNameAndTradeNameAndInnLike("%" + lastName + "%", "%" + firstName + "%", "%" + tradeName + "%", "%" + inn + "%"));
    }
}
