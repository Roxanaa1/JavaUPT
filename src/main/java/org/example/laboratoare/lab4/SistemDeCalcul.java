package org.example.laboratoare.lab4;

import lombok.*;


//get class
enum SistemOperare
{
    WINDOWS, LINUX
}

/**
 * Clasa {@code SistemDeCalcul} extinde clasa {@code Echipament} pentru a reprezenta un sistem de calcul,
 * cum ar fi un computer desktop sau un laptop. Aceasta clasă adaugă specificații tehnice relevante pentru
 * sistemele de calcul, inclusiv tipul monitorului, viteza procesorului, capacitatea HDD și sistemul de operare.
 */
@Getter
@NoArgsConstructor
@Setter
@AllArgsConstructor
public class SistemDeCalcul extends Echipament {
    /**
     * Tipul monitorului sistemului de calcul.
     */
    private String tipMonitor;

    /**
     * Viteza procesorului sistemului de calcul, exprimată în gigahertz (GHz).
     */
    private double vitezaProcesor;

    /**
     * Capacitatea HDD a sistemului de calcul, exprimată în gigabytes (GB).
     */
    private int capacitateHDD;

    /**
     * Sistemul de operare instalat pe sistemul de calcul, fie {@code WINDOWS} fie {@code LINUX}.
     */
    private SistemOperare sistemOperare;

    /**
     * Construiește un nou obiect {@code SistemDeCalcul} cu informații detaliate, inclusiv denumire, număr de inventar,
     * preț, zona din magazie, stare, tip monitor, viteza procesorului, capacitatea HDD și sistemul de operare.
     *
     * @param denumire Denumirea sistemului de calcul.
     * @param nr_inv Numărul de inventar al sistemului de calcul.
     * @param pret Prețul sistemului de calcul.
     * @param zona_mag Zona din magazie unde este plasat sistemul de calcul.
     * @param stareEchipament Starea actuală a sistemului de calcul (achiziționat, expus, vândut).
     * @param tipMonitor Tipul monitorului sistemului de calcul.
     * @param vitezaProcesor Viteza procesorului sistemului de calcul.
     * @param capacitateHDD Capacitatea HDD a sistemului de calcul.
     * @param sistemOperare Sistemul de operare instalat pe sistemul de calcul.
     */
    public SistemDeCalcul(String denumire, int nr_inv, int pret, String zona_mag, StareEchipament stareEchipament, String tipMonitor,double vitezaProcesor, int capacitateHDD, SistemOperare sistemOperare) {
        super(denumire, nr_inv, pret, zona_mag, stareEchipament);
        this.tipMonitor=tipMonitor;
        this.vitezaProcesor = vitezaProcesor;
        this.capacitateHDD = capacitateHDD;
        this.sistemOperare = sistemOperare;
    }

    /**
     * Returnează o reprezentare șir a obiectului {@code SistemDeCalcul}, incluzând toate detaliile sistemului de calcul.
     *
     * @return Un șir ce descrie sistemul de calcul, inclusiv tipul monitorului, viteza procesorului,
     * capacitatea HDD și sistemul de operare.
     */
    @Override
    public String toString() {
        return super.toString()  + ", Tip Monitor: " + tipMonitor + ", Viteza procesor: " + vitezaProcesor + " GHz, Capacitate HDD: " + capacitateHDD + " GB, Sistem operare: " + sistemOperare;
    }
}

