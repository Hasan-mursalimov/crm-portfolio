package ru.crm.portfolio.crmportfolioexample.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.crm.portfolio.crmportfolioexample.services.AccountService;

@Controller
@RequiredArgsConstructor
public class UsersController {

    private final AccountService accountService;

    @GetMapping("/users")
    public String getUsers(Model model) {
        model.addAttribute("accounts", accountService.getAllUsers());
        return "users";
    }

    @PostMapping("/users/{user-id}/delete")
    public String deleteUser(@PathVariable("user-id") Long userId){
        accountService.deleteUser(userId);
        return "redirect:/users";
    }
}
