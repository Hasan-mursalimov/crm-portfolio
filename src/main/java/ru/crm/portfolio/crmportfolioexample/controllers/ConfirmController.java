package ru.crm.portfolio.crmportfolioexample.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.crm.portfolio.crmportfolioexample.services.ConfirmService;

@RequiredArgsConstructor
@Controller
public class ConfirmController {

    private final ConfirmService confirmService;

    @GetMapping("/confirm/{uuid}")
    public String confirm(@PathVariable("uuid") String uuid) {
        if (confirmService.confirm(uuid)) {
            return "success_confirm";
        } else {
            return "not_success_confirm";
        }
    }

}
