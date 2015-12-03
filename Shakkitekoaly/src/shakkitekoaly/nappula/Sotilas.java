
package shakkitekoaly.nappula;

import static shakkitekoaly.nappula.Tyyppi.SOTILAS;

/**
 * Luokka perii Nappula luokan,
 * Sotilas on nappula joka pystyy siirtymään tavallisesti vain yhden ruudun
 * eteenpäin ja kulmittain yhden ruudun jos se syö sieltä.
 */
public class Sotilas extends Nappula {

    /**
     * Konstruktori kutsuu Nappulan konstruktoria annetuilla arvoilla ja lisää
     * siihen oman tyyppinsä.
     *
     * @param s Mihin nappula luodaan
     * @param vari Kumman pelaajan nappula on
     */
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
            if (y + i > 7 || y + i < 0) {
                continue;
            }
            if (this.getVari()) {
                paikat[k++] = new Sijainti(x - 1, y + i);
            } else {
                paikat[k++] = new Sijainti(x + 1, y + i);
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
