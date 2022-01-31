package ru.crm.portfolio.crmportfolioexample.security.details;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.crm.portfolio.crmportfolioexample.models.Account;
import ru.crm.portfolio.crmportfolioexample.repositories.AccountRepositories;

@Service("customUserDetailsService")
@RequiredArgsConstructor
public class UsersDetailsServiceImpl implements UserDetailsService {

    private final AccountRepositories accountRepositories;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Account account = accountRepositories.findByEmail(email).orElseThrow(()->
                new UsernameNotFoundException("User not found"));
        return new UserDetailsImpl(account);
    }
}
