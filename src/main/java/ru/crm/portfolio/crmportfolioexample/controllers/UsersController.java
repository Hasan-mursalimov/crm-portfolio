package ru.crm.portfolio.crmportfolioexample.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.crm.portfolio.crmportfolioexample.dto.AccountDto;
import ru.crm.portfolio.crmportfolioexample.services.AccountService;

@Controller
@RequiredArgsConstructor
public class UsersController {

    private final AccountService accountService;

    @GetMapping("/users")
    public String getUsers(@AuthenticationPrincipal(expression = "account.isSupervisor()") Boolean isSupervisor, Model model) {
        model.addAttribute("isSupervisor", isSupervisor);
        model.addAttribute("accounts", accountService.getAllUsers());
        return "users";
    }

    @PostMapping("/users/{user-id}/delete")
    public String deleteUser(@PathVariable("user-id") Long userId) {
        accountService.deleteUser(userId);
        return "redirect:/users";
    }

    @PostMapping("/users/{user-id}/update")
    public String updateForSalesPlan(@PathVariable("user-id") Long userId, AccountDto accountDto) {
        accountService.updateSalesPlan(userId, accountDto);
        return "redirect:/users";
    }
}
