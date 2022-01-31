package ru.crm.portfolio.crmportfolioexample.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SignInController {

    @RequestMapping("/signIn")
    public String getSignInPage(Authentication authentication) {
        if (authentication != null) {
            return "redirect:/";
        }
        return "sign_in";
    }


}
