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
