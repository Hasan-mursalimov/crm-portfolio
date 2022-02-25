package ru.crm.portfolio.crmportfolioexample.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.crm.portfolio.crmportfolioexample.form.SignUpForm;
import ru.crm.portfolio.crmportfolioexample.services.SignUpService;

import javax.validation.Valid;

@RequiredArgsConstructor
@Controller
public class SignUpController {

    private final SignUpService signUpService;

    @RequestMapping("/signUp")
    public String getSignUpPage(Model model) {
        model.addAttribute("signUpForm", new SignUpForm());
        return "sign_up";
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public String signUp(@Valid SignUpForm form, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            // если возникли ошибки, то создаем атрибут signUpForm для новой страницы и кладем туда ту же форму
            model.addAttribute("signUpForm", form);
            return "sign_up";
        }
        signUpService.signUp(form);
        return "redirect:/signIn";
    }



}

