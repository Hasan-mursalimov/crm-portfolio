package ru.crm.portfolio.crmportfolioexample.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Account {
    public enum Role {
        ADMIN, SALES_MANAGER, SERVICE_MANAGER, SUPERVISOR
    }

    public enum State{
        FIRED, WORKING
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long salesPlan;
    private Long completedPlan;
    private String email;
    @Column(name = "hash_password")
    private String hashPassword;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String numberTel;
    @Enumerated(value = EnumType.STRING)
    private Role role;
    @Enumerated(value = EnumType.STRING)
    private State state;
    @OneToMany(mappedBy = "account")
    private List<Client> client;



}
