package ru.crm.portfolio.crmportfolioexample.form;


import lombok.Data;
import ru.crm.portfolio.crmportfolioexample.enums.Role;

@Data
public class SignUpForm {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String numberTel;
    private Role role;

}
