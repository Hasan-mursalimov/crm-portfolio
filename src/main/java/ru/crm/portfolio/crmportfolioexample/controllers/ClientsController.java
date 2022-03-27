package ru.crm.portfolio.crmportfolioexample.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.crm.portfolio.crmportfolioexample.services.AccountService;
import ru.crm.portfolio.crmportfolioexample.services.ClientsService;

@Controller
@RequiredArgsConstructor
public class ClientsController {

    private final ClientsService clientsService;

    private final AccountService accountService;

    @GetMapping("/clients")
    public String getClients(Model model){
        model.addAttribute("clients", clientsService.getAllClient());
        model.addAttribute("accounts", accountService.findAllUserState());
        return "clients";
    }

}
