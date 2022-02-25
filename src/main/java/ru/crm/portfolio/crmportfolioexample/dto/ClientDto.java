package ru.crm.portfolio.crmportfolioexample.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.crm.portfolio.crmportfolioexample.models.Account;
import ru.crm.portfolio.crmportfolioexample.models.Client;

import javax.persistence.Column;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientDto {
    private Long id;
    private String firstName;
    private String lastName;
    private Double purchaseVolumes;
    private Long inn;
    private String legalName;
    private String tradeName;
    private String comment;
    private Calendar birthday;
    private LocalDate registrationDate;
    private Account account;
    private String numberTel;


    public static ClientDto from(Client client){
        return ClientDto.builder()
                .id(client.getId())
                .firstName(client.getFirstName())
                .lastName(client.getLastName())
                .purchaseVolumes(client.getPurchaseVolumes())
                .inn(client.getInn())
                .legalName(client.getLegalName())
                .tradeName(client.getTradeName())
                .numberTel(client.getNumberTel())
                .comment(client.getComment())
                .registrationDate(client.getRegistrationDate())
                .birthday(client.getBirthday())
                .account(client.getAccount())
                .build();
    }

    public static List<ClientDto> from(List<Client> clients){
        return clients.stream().map(ClientDto::from).collect(Collectors.toList());
    }
}
