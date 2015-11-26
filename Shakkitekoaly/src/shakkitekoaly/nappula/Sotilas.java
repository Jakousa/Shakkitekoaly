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

    @Override
    public Sijainti[] mahdollisetSiirtymat() {
        int x = this.getSijainti().getX();
        int y = this.getSijainti().getY();

        if ((!this.getVari() && x == 7)
                || (this.getVari() && x == 0)) {
            return new Sijainti[0];
        }
        Sijainti[] paikat;
        if (y == 0 || y == 7) {
            paikat = new Sijainti[2];
        } else {
            paikat = new Sijainti[3];
        }
        int k = 0;
        for (int i = -1; i < 2; i++) {
            if (x+i > 7 || x+i < 0) {
                continue;
            }
            if (this.getVari()) {
                paikat[k++] = new Sijainti(x+i,y-1);
            } else {
                paikat[k++] = new Sijainti(x+i,y+1);
            }
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
            return 'S';
        }
        return 's';
    }

}
