package ru.crm.portfolio.crmportfolioexample.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.crm.portfolio.crmportfolioexample.dto.SignUpForm;
import ru.crm.portfolio.crmportfolioexample.models.Account;
import ru.crm.portfolio.crmportfolioexample.repositories.AccountRepositories;

@Service
@RequiredArgsConstructor
public class SignUpServiceImpl implements SignUpService {

    private final PasswordEncoder passwordEncoder;

    private final AccountRepositories accountRepositories;

    @Override
    public void signUp(SignUpForm form) {

        Account account = Account.builder()
                .firstName(form.getFirstName())
                .lastName(form.getLastName())
                .email(form.getEmail())
                .numberTel(form.getNumberTel())
                .hashPassword(passwordEncoder.encode(form.getPassword()))
                .role(Account.Role.ADMIN)
                .state(Account.State.WORKING)
                .build();

        accountRepositories.save(account);
    }
}