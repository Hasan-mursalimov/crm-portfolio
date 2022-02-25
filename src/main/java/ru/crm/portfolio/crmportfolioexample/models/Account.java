package ru.crm.portfolio.crmportfolioexample.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.crm.portfolio.crmportfolioexample.enums.Role;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * класс аккаунт со свойствами <code>salesPlan</code>,<code>completedPlan</code>,<code>email</code>,<code>hashPassword</code>,
 * <code>firstName</code>,<code>lastName</code>,<code>numberTel</code>,<code>role</code>,<code>state</code>,<code>state</code>,
 * <code>client</code>
 * @author  Мурсалимов Хасан
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
    public enum State{
        /**
         *FIRED - уволенный
         * WORKING - работает
         */
        FIRED, WORKING
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /** план по продажам*/
    private Long salesPlan;
    /** выполненный план*/
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

    private String confirmUUID;

    public boolean isAdmin(){
        return role.equals(Role.ADMIN);
    }

}
