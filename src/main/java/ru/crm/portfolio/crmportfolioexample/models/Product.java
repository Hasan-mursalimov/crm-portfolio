package ru.crm.portfolio.crmportfolioexample.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * Класс продукт со свойствами <code>vendorСode</code>,<code>nameProduct</code>,<code>price</code>,<code>remainder</code>,
 * <code>clients</code>
 * @author Hasan Mursalimov
 * @version 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String vendorСode;
    private String nameProduct;
    private Double price;
    private Integer remainder;
    @OneToMany(mappedBy = "product")
    private List<Client> clients;
}
