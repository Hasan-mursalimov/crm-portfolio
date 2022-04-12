package ru.crm.portfolio.crmportfolioexample.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.crm.portfolio.crmportfolioexample.dto.ClientDto;
import ru.crm.portfolio.crmportfolioexample.exempions.UserNotFoundException;
import ru.crm.portfolio.crmportfolioexample.form.ClientSaveForm;
import ru.crm.portfolio.crmportfolioexample.models.Account;
import ru.crm.portfolio.crmportfolioexample.models.Client;
import ru.crm.portfolio.crmportfolioexample.repositories.AccountRepositories;
import ru.crm.portfolio.crmportfolioexample.repositories.ClientRepositories;

import java.time.LocalDate;
import java.util.List;

import static ru.crm.portfolio.crmportfolioexample.dto.ClientDto.from;


@Service
@RequiredArgsConstructor
public class ClientsServiceImpl implements ClientsService {

    private final ClientRepositories clientRepositories;

    private final AccountRepositories accountRepositories;

    @Override
    public void addClient(ClientSaveForm form) {

        Client newClient = Client.builder()
                .account(accountRepositories.getById(form.getAccountId()))
                .firstName(form.getFirstName())
                .lastName(form.getLastName())
                .email(form.getEmail())
                .registrationDate(LocalDate.now())
                .tradeName(form.getTradeName())
                .legalName(form.getLegalName())
                .numberTel(form.getNumberTel())
                .inn(form.getInn())
                .address(form.getAddress())
                .birthday(LocalDate.parse(form.getBirthday()))
                .state(Client.State.SATISFACTORILY)
                .build();

        clientRepositories.save(newClient);
    }

    @Override
    public List<ClientDto> getClientByUser(Long accountId) {
        accountRepositories.findById(accountId).orElseThrow(UserNotFoundException::new);
        return from(clientRepositories.findAllByAccount_id(accountId));
    }

    @Override
    public List<ClientDto> getAllClient() {
        return from(clientRepositories.findAll());
    }

    @Override
    public void addInfoClient(Long clientId, ClientSaveForm form) {
        Client client = clientRepositories.getById(clientId);
        client.setNumberTel(form.getNumberTel());
        client.setAddress(form.getAddress());
    }

    @Override
    public void addClientToUser(Long userId, ClientDto clientDto) {
        Account account = accountRepositories.getById(userId);
        Client client =clientRepositories.getById(clientDto.getId());
        client.setAccount(account);
        clientRepositories.save(client);
    }


}
