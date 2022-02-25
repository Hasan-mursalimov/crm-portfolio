package ru.crm.portfolio.crmportfolioexample.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.crm.portfolio.crmportfolioexample.dto.ClientDto;
import ru.crm.portfolio.crmportfolioexample.form.ClientSaveForm;
import ru.crm.portfolio.crmportfolioexample.services.AccountService;
import ru.crm.portfolio.crmportfolioexample.services.ClientService;

import javax.validation.Valid;

@RequiredArgsConstructor
@Controller
public class ClientSaveController {

    private final ClientService clientService;

    private final AccountService accountService;

    @RequestMapping("/saveClient")
    public String getSaveClientPage(Model model){
        model.addAttribute("clientSaveForm", new ClientSaveForm());
        model.addAttribute("accounts", accountService.findAllUserState());
        return "client_save";
    }

    @RequestMapping(value = "/saveClient", method = RequestMethod.POST)
    public String saveClient(@Valid ClientSaveForm form, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("clientSaveForm", new ClientSaveForm());
            return "client_save";
        }
        clientService.addClient(form);
        return "redirect:/users";
    }
}
