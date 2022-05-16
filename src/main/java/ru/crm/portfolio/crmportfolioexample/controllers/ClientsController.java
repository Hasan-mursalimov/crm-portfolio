package ru.crm.portfolio.crmportfolioexample.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.crm.portfolio.crmportfolioexample.dto.ClientDto;
import ru.crm.portfolio.crmportfolioexample.form.ClientSaveForm;
import ru.crm.portfolio.crmportfolioexample.services.AccountService;
import ru.crm.portfolio.crmportfolioexample.services.ClientProfileService;
import ru.crm.portfolio.crmportfolioexample.services.ClientsService;

import javax.validation.Valid;

@Controller
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientsController {

    private final ClientsService clientsService;

    private final AccountService accountService;

    private final ClientProfileService clientProfileService;

    @GetMapping("/{userId}")
    public String getClients(@PathVariable("userId") Long userId,Model model) {
        model.addAttribute("clients", clientsService.getAllClient());
        model.addAttribute("accounts", accountService.findAllUserState());
        model.addAttribute("clientWithOutUser", accountService.getClientWithOutUser());

        return "clients";
    }

    @PostMapping("/{userId}")
    public String addClintToUser(@PathVariable("userId") Long userId, ClientDto clientDto){
        clientsService.addClientToUser(userId, clientDto);
        return "redirect:/clients/"+userId;
    }

    @GetMapping("/clientProfile/{id}")
    public String getClientProfilePage(@PathVariable("id") Long clientId, Model model){
        model.addAttribute("client", clientProfileService.getClient(clientId));
        return "client_profile";
    }

    @PostMapping(value = "/clientProfile/{id}")
    public String addInfoClient(@PathVariable("id") Long clientId, Model model, ClientDto clientDto){
        clientProfileService.updateClientInfo(clientId, clientDto);
        return "redirect:/clientProfile/"+clientId;
    }

    public String comment(@PathVariable("comment") String comment, ClientDto clientDto, Model model){
        clientProfileService.addComment(clientDto);
        model.addAttribute("comment", comment);
        return "client_profile";
    }

    @GetMapping("/saveClient")
    public String getSaveClientPage(Model model) {
        model.addAttribute("clientSaveForm", new ClientSaveForm());
        model.addAttribute("accounts", accountService.findAllUserState());
        return "client_save";
    }

    @PostMapping(value = "/saveClient")
    public String saveClient(@Valid ClientSaveForm form, BindingResult bindingResult, Long clientId,
                             Model model) {
        if (bindingResult.hasErrors()){
            model.addAttribute("clientSaveForm", form);
            return "client_save";
        }
        clientsService.addClient(form);
        return "redirect:/users";
    }
}
