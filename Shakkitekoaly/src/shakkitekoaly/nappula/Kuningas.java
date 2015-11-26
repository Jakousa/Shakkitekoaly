/**
 *  Kuningas on nappula joka voi siirtyä yhden ruudun mihin tahansa suuntaan.
 */
package shakkitekoaly.nappula;

import java.util.Arrays;
import static shakkitekoaly.nappula.Tyyppi.KUNINGAS;

public class Kuningas extends Nappula {

    public Kuningas(Sijainti s, boolean vari) {
        super(s, vari, KUNINGAS);
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
        return (Math.abs(lahto.getX() - kohde.getX()) < 2
                && Math.abs(lahto.getY() - kohde.getY()) < 2);
    }

    @Override
    public Sijainti[] mahdollisetSiirtymat() {
        Sijainti[] paikat = new Sijainti[8];
        int k = 0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                int x = this.getSijainti().getX() + i;
                int y = this.getSijainti().getY() + j;
                if (x > 7 || x < 0 || y < 0 || y > 7) {
                    continue;
                }
                
                Sijainti s = new Sijainti(x, y);
                if (!s.equals(this.getSijainti())) {
                    paikat[k++] = s;
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
            return 'K';
        }
        return 'k';
    }

}
