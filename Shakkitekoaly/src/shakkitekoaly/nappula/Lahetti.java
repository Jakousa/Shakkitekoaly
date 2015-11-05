/**
 * 
 */
package shakkitekoaly.nappula;

import static shakkitekoaly.nappula.Tyyppi.LAHETTI;

public class Lahetti extends Nappula {

    public Lahetti(int x, int y, boolean vari) {
        super(x, y, vari, LAHETTI);
    }

    /**
     * Kertoo onko liikkuminen mahdollista nappulan sääntöjen mukaan.
     * @param lahto Mistä halutaan siirtyä.
     * @param kohde Minne halutaan siirtyä.
     * @return Palauttaa tosi jos siirtyminen on mahdollista, muuten epätosi.
     */
    @Override
    public boolean okSiirtya(Sijainti lahto, Sijainti kohde) {
        return (Math.abs(lahto.getX() - kohde.getX()) == 
                Math.abs(lahto.getY() - kohde.getY()));
    }

    /**
     * Jokaisella nappulalla on eri merkki.
     * @return Palauttaa nappulan kuvan.
     */
    @Override
    public String piirra() {
        if (this.getVari()) {
            return "L";
        }
        return "l";
    }
    
}
