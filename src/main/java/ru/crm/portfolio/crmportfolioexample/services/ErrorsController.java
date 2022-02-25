package ru.crm.portfolio.crmportfolioexample.services;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class ErrorsController {

    @GetMapping("/404")
    public String get404Page() {
        return "errors/error404";
    }

    @PostMapping("/500/enfe")
    public String get500Page(){
        return "errors/error500enfe";
    }

}
