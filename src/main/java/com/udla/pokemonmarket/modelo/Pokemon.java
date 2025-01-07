package com.udla.pokemonmarket.modelo;

import javax.persistence.*;
import org.openxava.annotations.*;
import lombok.*;

import java.util.Collection;

@Entity
@Getter @Setter
public class Pokemon {

    @Id
    @Hidden
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(length = 50)
    @Required
    String name;

    @Column @Required
    int number;

    @Column @Required
    int height;

    @Column(length = 200)
    String description;

    @OneToMany(mappedBy = "pokemon")
    Collection<PokemonType> types;


    @Files
    @Column(length = 32)
    @Stereotype("PHOTO")
    String image;
}
