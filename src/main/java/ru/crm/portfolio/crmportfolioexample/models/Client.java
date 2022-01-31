package ru.crm.portfolio.crmportfolioexample.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Client {

    /**
     * Статус клиента
     */
    public enum State {
        /**
         * NOT_CONFIRMED - не подтверждено
         * CONFIRMED - подтверждено
         * BANNED - забаннен
         * DELETED - удален
         * WITHOUT_A_MANAGER - без менеджера
         */
        NOT_CONFIRMED, CONFIRMED, BANNED, DELETED, WITHOUT_A_MANAGER
    }

    /**
     * статус клиента по пользованию сервисом
     */
    public enum RegistrationTern {
        /**
         * NEW - новый клиент
         * OLD - старый клиент
         */
        NEW, OLD;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private Double purchaseVolumes;
    private Long inn;
    @Column(name = "legal_name")
    private String legalName;
    @Column(name = "trade_name")
    private String tradeName;
    private LocalDate birthday;
    @Column(name = "registration_date")
    private LocalDate registrationDate;
    @Enumerated(value = EnumType.STRING)
    private State state;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @Enumerated(value = EnumType.STRING)
    private RegistrationTern tern;

    public int compareTo(Client client) {
        int result = 0;
        if (this.getPurchaseVolumes() != client.getPurchaseVolumes()) {
            return this.getPurchaseVolumes() - client.getPurchaseVolumes() > 0 ? -1 : 1;
        }
        if (this.getTern() != client.getTern()) {
            result = this.getTern() == RegistrationTern.NEW ? -1 : 1;
            return result;
        }
        if (this.getState() != client.getState()) {
            return this.getState() == State.WITHOUT_A_MANAGER ? -1 : 1;
        }
        return result;
    }

}
