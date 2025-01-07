package com.udla.pokemonmarket.modelo;

import javax.persistence.*;
import org.openxava.annotations.*;
import lombok.*;

@Entity @Getter @Setter
public class Inventory {

        @Id
        @Hidden
        @GeneratedValue(strategy = GenerationType.AUTO)
        Long id;

        @Column
        @Required
        int quantity;

        @ManyToOne(optional = false)
        @DescriptionsList
        Pokemon pokemon;


}


