package ru.crm.portfolio.crmportfolioexample.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.mapping.Collection;
import ru.crm.portfolio.crmportfolioexample.models.Client;

import java.util.List;
import java.util.stream.Collectors;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ClientDto {

    private Long id;
    private String firstName;
    private String lastName;
    private Double purchaseVolumes;
    private Long inn;
    private String legalName;
    private String tradeName;
    private List<String> comment;
    private String birthday;
    private String registrationDate;
    private String numberTel;
    private String address;
    private String email;


    public static ClientDto from(Client client){
        return ClientDto.builder()
                .id(client.getId())
                .firstName(client.getFirstName())
                .address(String.valueOf(client.getAddress()))
                .lastName(client.getLastName())
                .purchaseVolumes(client.getPurchaseVolumes())
                .inn(client.getInn())
                .legalName(client.getLegalName())
                .tradeName(client.getTradeName())
                .numberTel(String.valueOf(client.getNumberTel()))
                .comment(client.getComment())
                .registrationDate(client.getRegistrationDate().toString())
                .birthday(client.getBirthday().toString())
                .email(String.valueOf(client.getEmail()))
                .build();
    }

    public static List<ClientDto> from(List<Client> clients){
        return clients.stream().map(ClientDto::from).collect(Collectors.toList());
    }
}


