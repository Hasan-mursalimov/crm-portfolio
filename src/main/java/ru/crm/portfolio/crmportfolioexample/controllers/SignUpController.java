package ru.crm.portfolio.crmportfolioexample.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.crm.portfolio.crmportfolioexample.dto.SignUpForm;
import ru.crm.portfolio.crmportfolioexample.services.SignUpService;

@RequiredArgsConstructor
@Controller
public class SignUpController {

    private final SignUpService signUpService;

    @RequestMapping("/signUp")
    public String getSignUpPage(Authentication authentication) {
        if (authentication != null) {
            return "redirect:/";
        }
        return "sign_up";
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public String signUp(SignUpForm form) {
        signUpService.signUp(form);
        return "redirect:/signIn";
    }

}
