package ru.crm.portfolio.crmportfolioexample.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.crm.portfolio.crmportfolioexample.services.ProfileService;

@RequiredArgsConstructor
@Controller
@RequestMapping("/profile")
public class ProfileController {

    private final ProfileService profileService;


    @GetMapping("/{id}")
    public String getProfilePage(@PathVariable("id") Long userId,
                                 Model model) {
        model.addAttribute("user", profileService.getUser(userId));
        model.addAttribute("clients", profileService.getClientByUser(userId));
        return "profile";
    }

    @PostMapping("/{id}/delete/{clientId}")
    public String deleteClient(@PathVariable("id") Long userId,@PathVariable("clientId") Long clientId, Model model){
        model.addAttribute("client", profileService.deleteClient(clientId));
        return "redirect:/profile/"+userId;
    }
}
