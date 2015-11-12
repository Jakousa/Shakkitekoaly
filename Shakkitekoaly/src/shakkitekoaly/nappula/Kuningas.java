/**
 * 
 */
package shakkitekoaly.nappula;

import static shakkitekoaly.nappula.Tyyppi.KUNINGAS;

public class Kuningas extends Nappula {

    public Kuningas(Sijainti s, boolean vari) {
        super(s, vari, KUNINGAS);
    }

    /**
     * Kertoo onko liikkuminen mahdollista nappulan sääntöjen mukaan.
     * @param lahto Mistä halutaan siirtyä.
     * @param kohde Minne halutaan siirtyä.
     * @return Palauttaa tosi jos siirtyminen on mahdollista, muuten epätosi.
     */
    @Override
    public boolean okSiirtya(Sijainti lahto, Sijainti kohde) {
        return (Math.abs(lahto.getX() - kohde.getX()) < 2 && 
                Math.abs(lahto.getY() - kohde.getY()) < 2);
    }

    /**
     * Jokaisella nappulalla on eri merkki.
     * @return Palauttaa nappulan kuvan.
     */
    @Override
    public String piirra() {
        if (this.getVari()) {
            return "K";
        }
        return "k";    }
    
}
