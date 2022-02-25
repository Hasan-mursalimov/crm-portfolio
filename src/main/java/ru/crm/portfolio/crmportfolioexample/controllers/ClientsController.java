package ru.crm.portfolio.crmportfolioexample.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.crm.portfolio.crmportfolioexample.services.ClientService;

@Controller
@RequiredArgsConstructor
public class ClientsController {

    private final ClientService clientService;


}
