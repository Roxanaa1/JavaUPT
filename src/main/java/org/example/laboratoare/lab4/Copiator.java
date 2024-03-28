package org.example.laboratoare.lab4;

import lombok.*;

enum FormatCopiere {
    A3, A4
}
/**
 * Clasa {@code Copiator} extinde clasa {@code Echipament} și reprezintă un copiator din inventarul unei companii.
 * Această clasă stochează informații specifice despre copiatoare, inclusiv numărul de pagini pe care le poate printa cu un toner și formatul de copiere suportat.
 */
@Data
@Getter
@NoArgsConstructor
@Setter
@AllArgsConstructor
public class Copiator extends Echipament {
    /**
     * Numărul de pagini pe care copiatorul le poate printa cu un singur toner.
     */
    private int paginiToner;

    /**
     * Formatul de copiere suportat de copiator, care poate fi {@code A3} sau {@code A4}.
     */
    private FormatCopiere formatCopiere;

    /**
     * Construiește un nou obiect {@code Copiator} cu informații detaliate, inclusiv denumire, număr de inventar, preț, zona din magazie, stare, numărul de pagini pe toner și formatul de copiere.
     *
     * @param denumire Denumirea echipamentului.
     * @param nr_inv Numărul de inventar al echipamentului.
     * @param pret Prețul echipamentului.
     * @param zona_mag Zona din magazie unde este plasat echipamentul.
     * @param stareEchipament Starea actuală a echipamentului (achiziționat, expus, vândut).
     * @param paginiToner Numărul de pagini pe care copiatorul le poate printa cu un toner.
     * @param formatCopiere Formatul de copiere suportat de copiator.
     */
    public Copiator(String denumire, int nr_inv, int pret, String zona_mag, StareEchipament stareEchipament, int paginiToner, FormatCopiere formatCopiere) {
        super(denumire, nr_inv, pret, zona_mag, stareEchipament);
        this.paginiToner = paginiToner;
        this.formatCopiere = formatCopiere;
    }

    /**
     * Returnează o reprezentare șir a obiectului {@code Copiator}, incluzând toate detaliile echipamentului.
     *
     * @return Un șir ce descrie copiatorul.
     */
    @Override
    public String toString() {
        return super.toString() + "Pagini toner:" + paginiToner + "," + "Format de copiere:" + formatCopiere;
    }
}
