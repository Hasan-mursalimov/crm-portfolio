package ru.crm.portfolio.crmportfolioexample.dto;


import lombok.Data;

@Data
public class SignUpForm {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String numberTel;
}
