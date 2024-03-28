package org.example.laboratoare.lab4;

import lombok.*;

/**
 * Enumerația pentru diferitele moduri de tipărire ale unei imprimante.
 */
enum ModTiparire {
    COLOR, MONOCROM
}

/**
 * Clasa care reprezintă o imprimantă.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Imprimanta extends Echipament {
    /**
     * Viteza de imprimare în pagini pe minut.
     */
    private int ppm;

    /**
     * Rezoluția de tipărire a imprimantei.
     */
    private String dpi;

    /**
     * Numărul de pagini ce pot fi tipărite cu un cartuș.
     */
    private int paginiCarutus;

    /**
     * Modul de tipărire al imprimantei.
     */
    private ModTiparire modDeTiparire;

    /**
     * Constructor care inițializează toate câmpurile imprimantei.
     */
    public Imprimanta(String denumire, int nr_inv, int pret, String zona_mag, StareEchipament stareEchipament, int ppm, String dpi, int paginiCarutus, ModTiparire modDeTiparire) {
        super(denumire, nr_inv, pret, zona_mag, stareEchipament);
        this.ppm = ppm;
        this.dpi = dpi;
        this.paginiCarutus = paginiCarutus;
        this.modDeTiparire = modDeTiparire;
    }

    /**
     * Suprascrierea metodei toString pentru a afișa detaliile imprimantei.
     */
    @Override
    public String toString() {
        return super.toString() + ", PPM: " + ppm + ", DPI: " + dpi + ", Pagini per cartus: " + paginiCarutus + ", Mod de tiparire: " + modDeTiparire;
    }
}
