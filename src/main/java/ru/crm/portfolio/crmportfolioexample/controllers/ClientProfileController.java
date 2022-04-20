package ru.crm.portfolio.crmportfolioexample.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.crm.portfolio.crmportfolioexample.dto.ClientDto;
import ru.crm.portfolio.crmportfolioexample.form.ClientSaveForm;
import ru.crm.portfolio.crmportfolioexample.services.ClientProfileService;

import javax.validation.Valid;

@RequiredArgsConstructor
@Controller
public class ClientProfileController {

    private final ClientProfileService clientProfileService;

    @GetMapping("/{id}/clientProfile")
    public String getClientProfilePage(@PathVariable("id") Long clientId, Model model){
        model.addAttribute("client", clientProfileService.getClient(clientId));
        return "client_profile";
    }

    @RequestMapping(value = "/{id}/clientProfile", method = RequestMethod.POST)
    public String addInfoClient(@PathVariable("id") Long clientId, Model model){
//        clientProfileService.updateClientInfo(clientId);
        return "redirect:/clients";
    }

    public String comment(@PathVariable("comment") String comment, ClientDto clientDto, Model model){
        clientProfileService.addComment(clientDto);
        model.addAttribute("comment", comment);
        return "client_profile";
    }
}
