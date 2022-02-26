package ru.crm.portfolio.crmportfolioexample.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.crm.portfolio.crmportfolioexample.form.SignUpForm;
import ru.crm.portfolio.crmportfolioexample.models.Account;
import ru.crm.portfolio.crmportfolioexample.repositories.AccountRepositories;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SignUpServiceImpl implements SignUpService {

    private final PasswordEncoder passwordEncoder;

    private final AccountRepositories accountsRepository;

    @Override
    public void signUp(SignUpForm form) {

        Account account = Account.builder()
                .firstName(form.getFirstName())
                .lastName(form.getLastName())
                .email(form.getEmail())
                .hashPassword(passwordEncoder.encode(form.getPassword()))
                .role(form.getRole())
                .state(Account.State.WORKING)
                .confirmUUID(UUID.randomUUID().toString())
                .build();

        accountsRepository.save(account);
    }
}
