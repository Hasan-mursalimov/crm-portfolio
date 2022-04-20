package ru.crm.portfolio.crmportfolioexample.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.crm.portfolio.crmportfolioexample.form.ClientSaveForm;
import ru.crm.portfolio.crmportfolioexample.services.AccountService;
import ru.crm.portfolio.crmportfolioexample.services.ClientsService;

import javax.validation.Valid;

@RequiredArgsConstructor
@Controller
public class ClientSaveController {

    private final ClientsService clientsService;

    private final AccountService accountService;

    @RequestMapping("/saveClient")
    public String getSaveClientPage(Model model) {
        model.addAttribute("clientSaveForm", new ClientSaveForm());
        model.addAttribute("accounts", accountService.findAllUserState());
        return "client_save";
    }

    @RequestMapping(value = "/saveClient", method = RequestMethod.POST)
    public String saveClient(@Valid ClientSaveForm form, BindingResult bindingResult, Long clientId,
                             Model model) {
        if (bindingResult.hasErrors()){
            model.addAttribute("clientSaveForm", form);
            return "client_save";
        }
        clientsService.addClient(form);
        return "redirect:/clients";
    }
}
