package ru.crm.portfolio.crmportfolioexample.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.crm.portfolio.crmportfolioexample.enums.Role;

import javax.persistence.*;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.util.List;

/**
 * класс аккаунт со свойствами <code>salesPlan</code>,<code>completedPlan</code>,<code>email</code>,<code>hashPassword</code>,
 * <code>firstName</code>,<code>lastName</code>,<code>numberTel</code>,<code>role</code>,<code>state</code>,<code>state</code>,
 * <code>client</code>
 *
 * @author Мурсалимов Хасан
 * @version 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Account implements Serializable {

    private static final long serialVersionUID = -2412078133648480727L;

    /**
     * статус аккаунта
     */
    public enum State {
        /**
         * FIRED - уволенный
         * WORKING - работает
         */
        FIRED, WORKING
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * план по продажам
     */
    @Column(columnDefinition = "integer default 0")
    @PositiveOrZero
    private Integer salesPlan;
    /**
     * выполненный план
     */
    @Column(columnDefinition = "integer default 0")
    @PositiveOrZero
    private Integer completedPlan;
    @Column(nullable = false,unique = true)
    private String email;
    @Column(name = "hash_password", nullable = false)
    private String hashPassword;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String numberTel;
    @Enumerated(value = EnumType.STRING)
    private Role role;
    @Enumerated(value = EnumType.STRING)
    private State state;
    @OneToMany(mappedBy = "account")
    private List<Client> client;

    private String confirmUUID;


    public boolean isAdmin() {
        return role.equals(Role.ADMIN);
    }

    public boolean isSupervisor() {
        return role.equals(Role.SUPERVISOR);
    }

    public boolean isSalesManager(){
        return role.equals(Role.SALES_MANAGER);
    }

}
