package ru.crm.portfolio.crmportfolioexample.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.crm.portfolio.crmportfolioexample.dto.ClientDto;
import ru.crm.portfolio.crmportfolioexample.form.ClientSaveForm;
import ru.crm.portfolio.crmportfolioexample.models.Client;
import ru.crm.portfolio.crmportfolioexample.repositories.ClientRepositories;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepositories clientRepositories;

    @Override
    public void addClient(ClientSaveForm form) {

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

    @Override
    public List<ClientDto> getAllClients() {
        return ClientDto.from(clientRepositories.findAll());
    }
}
