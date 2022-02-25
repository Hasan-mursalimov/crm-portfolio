package ru.crm.portfolio.crmportfolioexample.form;

import lombok.Data;
import ru.crm.portfolio.crmportfolioexample.models.Account;

import java.time.LocalDate;
import java.util.Calendar;

@Data
public class ClientSaveForm {
    private Long id;
    private String firstName;
    private String lastName;
    private Double purchaseVolumes;
    private Long inn;
    private String legalName;
    private String tradeName;
    private Calendar birthday;
    private LocalDate registrationDate;
    private Account account;
    private String numberTel;
}
