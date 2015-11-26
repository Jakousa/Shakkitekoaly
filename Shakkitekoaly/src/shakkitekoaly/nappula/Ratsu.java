/**
 * Ratsu on nappula joka voi siirtyä erityisellä tavalla, Se ei rajoita jos
 * tiellä on toinen nappula ja ratsu siirtyy L muodossa: ensin kaksi haluttuun 
 * suuntaan ja sitten yhden siitä sivulle.
 */
package shakkitekoaly.nappula;

import java.util.Arrays;
import static shakkitekoaly.nappula.Tyyppi.RATSU;

public class Ratsu extends Nappula {

    public Ratsu(Sijainti s, boolean vari) {
        super(s, vari, RATSU);
    }

    /**
     * Kertoo onko liikkuminen mahdollista nappulan sääntöjen mukaan.
     *
     * @param lahto Mistä halutaan siirtyä.
     * @param kohde Minne halutaan siirtyä.
     * @return Palauttaa tosi jos siirtyminen on mahdollista, muuten epätosi.
     */
    @Override
    public boolean okSiirtya(Sijainti lahto, Sijainti kohde) {
        int x1 = lahto.getX();
        int x2 = kohde.getX();
        int y1 = lahto.getY();
        int y2 = kohde.getY();

        return (Math.abs(x1 - x2) == 2 && Math.abs(y1 - y2) == 1)
                || (Math.abs(x1 - x2) == 1 && Math.abs(y1 - y2) == 2);
    }

    @Override
    public Sijainti[] mahdollisetSiirtymat() {
        Sijainti[] paikat = new Sijainti[8];
        int k = 0;
        for (int i = 1; i < 3; i++) {
            int x1 = this.getSijainti().getX() + i;
            int y1 = this.getSijainti().getY() + (3 - i);
            int x2 = this.getSijainti().getX() - i;
            int y2 = this.getSijainti().getY() - (3 - i);
            if (!(x1 > 7)) {
                if (!(y1 > 7)) {
                    paikat[k++] = new Sijainti(x1, y1);
                }
                if (!(y2 < 0)) {
                    paikat[k++] = new Sijainti(x1, y2);
                }
            }
            if (!(x2 < 0)) {
                if (!(y1 > 7)) {
                    paikat[k++] = new Sijainti(x2, y1);
                }
                if (!(y2 < 0)) {
                    paikat[k++] = new Sijainti(x2, y2);
                }
            }
        }
        if (k < 8) {
            Sijainti[] lopullinen = Arrays.copyOf(paikat, k - 1);
            return lopullinen;
        }
        return paikat;
    }

    /**
     * Jokaisella nappulalla on eri merkki.
     *
     * @return Palauttaa nappulan kuvan.
     */
    @Override
    public char piirra() {
        if (this.getVari()) {
            return 'R';
        }
        return 'r';

    }

}
