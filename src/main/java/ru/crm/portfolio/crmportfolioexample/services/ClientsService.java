package ru.crm.portfolio.crmportfolioexample.services;

import ru.crm.portfolio.crmportfolioexample.dto.ClientDto;
import ru.crm.portfolio.crmportfolioexample.form.ClientSaveForm;

import java.util.List;

public interface ClientsService {

    void addClient(ClientSaveForm form);

    List<ClientDto> getClientByUser(Long accountId);

    List<ClientDto>getAllClient();


    void addInfoClient(Long clientId,ClientSaveForm form);


}
