/**
 *
 */
package shakkitekoaly.nappula;

import static shakkitekoaly.nappula.Tyyppi.KUNINGATAR;

public class Kuningatar extends Nappula {

    public Kuningatar(Sijainti s, boolean vari) {
        super(s, vari, KUNINGATAR);
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
                == Math.abs(lahto.getY() - kohde.getY()))
                || (kohde.getX() == lahto.getX() || kohde.getY() == lahto.getY());
    }

    @Override
    public Sijainti[] mahdollisetSiirtymat() {
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
            return 'Q';
        }
        return 'q';
    }

}
