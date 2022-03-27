package ru.crm.portfolio.crmportfolioexample.form;

import lombok.Data;
import org.springframework.format.annotation.NumberFormat;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
public class ClientSaveForm {
    private Long id;
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @NumberFormat
    private Long inn;
    @NotEmpty
    private String legalName;
    @NotEmpty
    private String tradeName;
    private String birthday;
    @NotEmpty
    @Email
    private String email;
    private String registrationDate;
    @NotEmpty
    private String address;
    @NotEmpty
    private String numberTel;
    private Long accountId;
}
