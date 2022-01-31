package ru.crm.portfolio.crmportfolioexample.services;

import ru.crm.portfolio.crmportfolioexample.dto.AccountDto;

import java.util.List;

public interface AccountService {


    List<AccountDto> getAllUsers();

    void deleteUser(Long userId);
}
