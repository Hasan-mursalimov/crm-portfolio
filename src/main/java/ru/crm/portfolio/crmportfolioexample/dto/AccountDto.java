package ru.crm.portfolio.crmportfolioexample.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.crm.portfolio.crmportfolioexample.models.Account;
import ru.crm.portfolio.crmportfolioexample.enums.Role;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AccountDto {

    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String numberTel;
    private String password;
    private Role role;

    public static AccountDto from(Account account){
        return AccountDto.builder()
                .id(account.getId())
                .email(account.getEmail())
                .firstName(account.getFirstName())
                .lastName(account.getLastName())
                .numberTel(account.getNumberTel())
                .password(account.getHashPassword())
                .role(account.getRole())
                .build();
    }
    public static List<AccountDto> from(List<Account> accounts) {
        return accounts.stream().map(AccountDto::from).collect(Collectors.toList());
    }
}
