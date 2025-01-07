package com.udla.pokemonmarket.modelo;

import javax.persistence.*;
import org.openxava.annotations.*;
import lombok.*;


@Entity
@Getter
@Setter
public class PokemonType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Hidden
    Long id;

    @Column(length = 50)
    @Required
    String name;

    @ManyToOne
    Pokemon pokemon;

}
