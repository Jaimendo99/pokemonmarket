package com.udla.pokemonmarket.modelo;


import javax.persistence.*;
import org.openxava.annotations.*;
import lombok.*;
import org.openxava.calculators.CurrentDateCalculator;
import java.util.Collection;

@Entity @Getter @Setter
public class InvoiceHeader {

    @Id
    @Hidden
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Required
    @DefaultValueCalculator(CurrentDateCalculator.class)
    java.util.Date date;

    @ManyToOne
    @DescriptionsList
    Customer customer;

    @OneToMany(mappedBy = "invoiceHeader")
    Collection<InvoiceDetail> details;

}
