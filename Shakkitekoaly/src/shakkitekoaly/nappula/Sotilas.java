/**
 *
 */
package shakkitekoaly.nappula;

import static shakkitekoaly.nappula.Tyyppi.SOTILAS;

public class Sotilas extends Nappula {

    public Sotilas(Sijainti s, boolean vari) {
        super(s, vari, SOTILAS);
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
        int i = 1;
        if (this.getVari()) {
            i = -1;
        }
        return (Math.abs(lahto.getY() - kohde.getY()) < 2
                && lahto.getX() + i == kohde.getX());
    }

    /**
     * Jokaisella nappulalla on eri merkki.
     *
     * @return Palauttaa nappulan kuvan.
     */
    @Override
    public String piirra() {
        if (this.getVari()) {
            return "S";
        }
        return "s";
    }

}
