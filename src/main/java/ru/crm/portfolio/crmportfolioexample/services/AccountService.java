package ru.crm.portfolio.crmportfolioexample.services;

import ru.crm.portfolio.crmportfolioexample.dto.AccountDto;
import ru.crm.portfolio.crmportfolioexample.dto.ClientDto;
import ru.crm.portfolio.crmportfolioexample.models.Account;

import java.util.List;

public interface AccountService {

    /**
     *вывод списка аккаунт(через класс ДТО)
     */
    List<AccountDto> getAllUsers();

    List<AccountDto> findAllUserState();


    /**
     * удаление аккаунта
     * @param userId - id аккаунта
     */
    void deleteUser(Long userId);

    /**
     * добавление аккаунта
     * @param accountDto
     */
    void addAccount(AccountDto accountDto);

    void addClientToUser(Long id, ClientDto clientDto);
}
