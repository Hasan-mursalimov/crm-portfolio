package ru.crm.portfolio.crmportfolioexample.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.crm.portfolio.crmportfolioexample.dto.ClientDto;
import ru.crm.portfolio.crmportfolioexample.form.ClientSaveForm;
import ru.crm.portfolio.crmportfolioexample.models.Client;
import ru.crm.portfolio.crmportfolioexample.repositories.ClientRepositories;

import static ru.crm.portfolio.crmportfolioexample.dto.ClientDto.from;

@RequiredArgsConstructor
@Service
public class ClientProfileServiceImpl implements ClientProfileService {

    private final ClientRepositories clientRepositories;

    @Override
    public ClientDto getClient(Long clientId) {
        return from(clientRepositories.getById(clientId));
    }

    @Override
    public void addComment(ClientDto client) {
        Client client1 = Client.builder()
                .comment(client.getComment())
                .build();
        clientRepositories.save(client1);
    }

    @Override
    public void updateClientInfo(Long clientId) {
        Client clientUpdate = clientRepositories.getById(clientId);
        clientUpdate.setEmail(clientUpdate.getEmail());
        clientUpdate.setNumberTel(clientUpdate.getNumberTel());
        clientUpdate.setAddress(clientUpdate.getAddress());
        clientRepositories.save(clientUpdate);
    }


}
