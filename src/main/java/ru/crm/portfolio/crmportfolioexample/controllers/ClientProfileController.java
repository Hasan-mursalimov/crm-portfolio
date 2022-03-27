package ru.crm.portfolio.crmportfolioexample.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.crm.portfolio.crmportfolioexample.services.ClientProfileService;

@RequiredArgsConstructor
@Controller
public class ClientProfileController {

    private final ClientProfileService clientProfileService;

    @GetMapping("/{id}/clientProfile")
    public String getClientProfilePage(@PathVariable("id") Long clientId, Model model){
        model.addAttribute("client", clientProfileService.getClient(clientId));
        return "client_profile";
    }
}
