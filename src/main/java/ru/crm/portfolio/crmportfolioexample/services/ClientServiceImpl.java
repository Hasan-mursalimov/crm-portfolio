package ru.crm.portfolio.crmportfolioexample.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.crm.portfolio.crmportfolioexample.dto.ClientDto;
import ru.crm.portfolio.crmportfolioexample.form.ClientSaveForm;
import ru.crm.portfolio.crmportfolioexample.models.Client;
import ru.crm.portfolio.crmportfolioexample.repositories.AccountRepositories;
import ru.crm.portfolio.crmportfolioexample.repositories.ClientRepositories;

import java.time.LocalDate;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private ClientRepositories clientRepositories;

    private AccountService accountService;

    @Override
    public void addClient(ClientSaveForm form) {

        accountService.findAllUserState();

        Client newClient = Client.builder()
                .account(form.getAccount())
                .firstName(form.getFirstName())
                .lastName(form.getLastName())
                .registrationDate(form.getRegistrationDate())
                .tradeName(form.getTradeName())
                .inn(form.getInn())
                .birthday(form.getBirthday())
                .build();

        clientRepositories.save(newClient);
    }
}
