/**
 *
 */
package shakkitekoaly.nappula;

import java.util.Arrays;
import static shakkitekoaly.nappula.Tyyppi.LAHETTI;

public class Lahetti extends Nappula {

    public Lahetti(Sijainti s, boolean vari) {
        super(s, vari, LAHETTI);
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
        return (Math.abs(lahto.getX() - kohde.getX())
                == Math.abs(lahto.getY() - kohde.getY()));
    }

    @Override
    public Sijainti[] mahdollisetSiirtymat() {
        Sijainti[] paikat = new Sijainti[13];

        int k = 0;
        for (int i = 1; i < 7; i++) {
            int x1 = this.getSijainti().getX() + i;
            int y1 = this.getSijainti().getY() + i;
            int x2 = this.getSijainti().getX() - i;
            int y2 = this.getSijainti().getY() - i;
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
        if (k < 13) {
            Sijainti[] lopullinen = Arrays.copyOf(paikat, k - 1);
            return lopullinen;
        }
        return null;
    }

    /**
     * Jokaisella nappulalla on eri merkki.
     *
     * @return Palauttaa nappulan kuvan.
     */
    @Override
    public char piirra() {
        if (this.getVari()) {
            return 'L';
        }
        return 'l';
    }

}
