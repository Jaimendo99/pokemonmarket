package com.udla.pokemonmarket.modelo;


import javax.persistence.*;
import org.openxava.annotations.*;
import lombok.*;

@Entity
@Getter
@Setter

public class Customer {
    @Id
    @Hidden
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(length = 50)
    @Required
    String name;

    @Column(length = 50)
    @Required
    String lastName;

    @Column(length = 50)
    @Required
    String dni;

    @Column(length = 50)
    String phone;

    @Column(length = 50)
    String email;


    private boolean validateDNI(String x) {
        int suma = 0;
        if (x.length() == 9) {
            return false;
        } else {
            int[] a = new int[x.length() / 2];
            int[] b = new int[(x.length() / 2)];
            int c = 0;
            int d = 1;
            for (int i = 0; i < x.length() / 2; i++) {
                a[i] = Integer.parseInt(String.valueOf(x.charAt(c)));
                c = c + 2;
                if (i < (x.length() / 2) - 1) {
                    b[i] = Integer.parseInt(String.valueOf(x.charAt(d)));
                    d = d + 2;
                }
            }

            for (int i = 0; i < a.length; i++) {
                a[i] = a[i] * 2;
                if (a[i] > 9) {
                    a[i] = a[i] - 9;
                }
                suma = suma + a[i] + b[i];
            }
            int aux = suma / 10;
            int dec = (aux + 1) * 10;
            if ((dec - suma) == Integer.parseInt(String.valueOf(x.charAt(x.length() - 1))))
                return true;
            else return suma % 10 == 0 && x.charAt(x.length() - 1) == '0';

        }
    }

    @PreCreate
    @PreUpdate
    public void validateDNI() {
        if (!validateDNI(dni)) {
            throw new RuntimeException("DNI is not valid");
        }
    }


}
