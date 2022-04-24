package ru.crm.portfolio.crmportfolioexample.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.crm.portfolio.crmportfolioexample.converter.StringToListConverter;

import javax.persistence.*;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDate;
import java.util.List;

/**
 * Класс клиент со свойствами <code>firstName</code>,<code>lastName</code>,<code>purchaseVolumes</code>,<code>inn</code>,
 * <code>legalName</code>,<code>tradeName</code>,<code>comment</code>,<code>birthday</code>,<code>registrationDate</code>,
 * <code>state</code>,<code>account</code>,<code>product</code>,<code>tern</code>,c методом <code>compareTo</code>,
 * с ENUM <code>State</code>,<code>RegistrationTern</code>
 *
 * @author Hasan Mursalimov
 * @version 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    /**
     * поле объема закупа
     */
    @PositiveOrZero
    private Double purchaseVolumes;
    /**
     * поле Инн
     */
    @Column(nullable = false, unique = true)
    private Long inn;
    /**
     * поле официальное название
     */
    @Column(name = "legal_name")
    private String legalName;
    /**
     * поле торговое название
     */
    @Column(name = "trade_name")
    private String tradeName;
    @ElementCollection
    @Convert(converter = StringToListConverter.class)
    private List<String> comment;
    @Column(nullable = false)
    private LocalDate birthday;
    /**
     * поле дата регистрации
     */
    @Column(name = "registration_date")
    private LocalDate registrationDate;
    @Enumerated(value = EnumType.STRING)
    @ManyToOne
    @JoinColumn(name = "account_id", columnDefinition = "integer default 0")
    private Account account;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @Column(nullable = false)
    @ElementCollection
    @Convert(converter = StringToListConverter.class)
    private List<String> numberTel;
    @Column(nullable = false)
    @ElementCollection
    @Convert(converter = StringToListConverter.class)
    private List<String> address;
    private State state;
    @Column(nullable = false, unique = true)
    @ElementCollection
    @Convert(converter = StringToListConverter.class)
    private List<String> email;

    public enum State {
        BANNED, NOT_MANAGER, SATISFACTORILY
    }


    /**
     * сортировка клиента по закупу, времени пребыванию на портале и статусу
     *
     * @param client - передаваемый клиент
     * @return возвращение результата
     */
    public int compareTo(Client client) {
        int result = 0;
        if (this.getPurchaseVolumes() != client.getPurchaseVolumes()) {
            return this.getPurchaseVolumes() - client.getPurchaseVolumes() > 0 ? -1 : 1;
        }
        return result;
    }
}
