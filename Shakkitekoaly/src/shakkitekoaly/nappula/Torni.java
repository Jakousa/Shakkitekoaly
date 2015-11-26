/**
 *  Torni on nappula joka pystyy siirtymään kuinka tahansa paljon 
 *  suoraan eteen, taakse tai sivuille.
 */
package shakkitekoaly.nappula;

import static shakkitekoaly.nappula.Tyyppi.TORNI;

public class Torni extends Nappula {

    public Torni(Sijainti s, boolean vari) {
        super(s, vari, TORNI);
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
        return (kohde.getX() == lahto.getX() || kohde.getY() == lahto.getY());
    }

    @Override
    public Sijainti[] mahdollisetSiirtymat() {
        Sijainti[] paikat = new Sijainti[14];
        int x = this.getSijainti().getX();
        int y = this.getSijainti().getY();
        for (int i = 0, j = 0, k = 7; i < 8; i++) {
            Sijainti s = new Sijainti(x, i);
            Sijainti h = new Sijainti(i, y);
            if (!(s.equals(this.getSijainti()))) {
                paikat[j++] = s;
            }
            if (!(h.equals(this.getSijainti()))) {
                paikat[k++] = h;
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
            return 'T';
        }
        return 't';

    }

}
