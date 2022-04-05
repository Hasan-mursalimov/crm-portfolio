package ru.crm.portfolio.crmportfolioexample.services;

import ru.crm.portfolio.crmportfolioexample.dto.ClientDto;

public interface ClientProfileService {

    ClientDto getClient(Long clientId);

    void addComment(ClientDto client);

    void updateClientInfo(Long clientId, ClientDto client);


}
