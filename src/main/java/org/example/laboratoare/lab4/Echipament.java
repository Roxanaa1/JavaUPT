package org.example.laboratoare.lab4;

import lombok.*;

/**
 * Enumerația pentru diferitele stări ale unui echipament.
 */
enum StareEchipament {
    ACHIZITIONAT, EXPUS, VANDUT
}

/**
 * Clasa de bază pentru reprezentarea unui echipament.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
abstract class Echipament {
    /**
     * Denumirea echipamentului.
     */
    private String denumire;

    /**
     * Numărul de inventar al echipamentului.
     */
    private int nr_inv;

    /**
     * Prețul echipamentului.
     */
    private int pret;

    /**
     * Zona magaziei în care se află echipamentul.
     */
    private String zona_mag;

    /**
     * Starea actuală a echipamentului.
     */
    private StareEchipament stareEchipament;
}
