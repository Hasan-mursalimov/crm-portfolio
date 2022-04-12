package ru.crm.portfolio.crmportfolioexample.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.crm.portfolio.crmportfolioexample.dto.ClientDto;
import ru.crm.portfolio.crmportfolioexample.services.AccountService;
import ru.crm.portfolio.crmportfolioexample.services.ClientsService;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class ClientsController {

    private final ClientsService clientsService;

    private final AccountService accountService;

    @GetMapping("/{userId}/clients")
    public String getClients(@PathVariable("userId") Long userId,Model model) {
        model.addAttribute("clients", clientsService.getAllClient());
        model.addAttribute("accounts", accountService.findAllUserState());
        model.addAttribute("clientWithOutUser", accountService.getClientWithOutUser());

        return "clients";
    }

    @PostMapping("/{userId}/clients")
    public String addClintToUser(@PathVariable("userId") Long userId, ClientDto clientDto){
        clientsService.addClientToUser(userId, clientDto);
        return "redirect:/"+userId+"/clients";
    }
}
