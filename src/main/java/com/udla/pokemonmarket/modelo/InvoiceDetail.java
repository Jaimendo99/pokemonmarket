package com.udla.pokemonmarket.modelo;


import javax.persistence.*;
import org.openxava.annotations.*;
import lombok.*;
import org.openxava.calculators.CurrentDateCalculator;

@Entity @Getter @Setter
public class InvoiceDetail {

    @Id
    @Hidden
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column
    @Required
    int quantity;

    @Column
    @Required
    double price;

    @ManyToOne(optional = false)
    @DescriptionsList
    Pokemon pokemon;

    @ManyToOne
    InvoiceHeader invoiceHeader;
}
