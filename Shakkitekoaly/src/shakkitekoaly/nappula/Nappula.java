/**
 * Abstrakti luokka pitää sisällään metodeja kuten siirtmistarkastelua jotka
 * muuten täytyisi toistaa jokaiselle (6) nappulalle erikseen.
 *
 * Sisältää sijainnin, nappulan tyypin ja värin.
 */
package shakkitekoaly.nappula;

import java.util.Objects;

public abstract class Nappula {

    private Sijainti sijainti;
    private Tyyppi tyyppi;
    private boolean vari;

    /**
     * Konstruktori luo uuden sijainnin nappulalle annetuista x ja y arvoista.
     *
     * @param s Sijaintiin laudalla.
     * @param vari Pelaaja jolle nappula kuuluu.
     * @param tyyppi Nappulan tyyppi (Torni, Sotilas, jne.)
     */
    public Nappula(Sijainti s, boolean vari, Tyyppi tyyppi) {
        this.sijainti = s;
        this.vari = vari;
        this.tyyppi = tyyppi;
    }

    public Tyyppi getTyyppi() {
        return tyyppi;
    }

    public boolean getVari() {
        return vari;
    }

    public Sijainti getSijainti() {
        return sijainti;
    }

    public void setSijainti(Sijainti s) {
        this.sijainti = s;
    }

    /**
     *
     * Tarkistaa onko siirtyminen mahdollista laudan rajojen mukaan ja vielä
     * kutsuu okSiirtya(lahto, kohde) jotta saadaan nappulakohtaiset säännöt ja
     * voiko niiden mukaan siirtyä.
     *
     * @param lahto Mistä halutaan siirtyä
     * @param kohde Minne halutaan siirtyä
     * @return Palauttaa tosi jos siirtyminen on mahdollista, muuten epätosi.
     */
    public boolean siirry(Sijainti lahto, Sijainti kohde) {
        if (lahto.getX() == kohde.getX() && lahto.getY() == kohde.getY()) {
            return false;
        }
        return okSiirtya(lahto, kohde);
    }

    /**
     * Tarkistaa onko siirto mahdollinen nappulan sääntöjen mukaan, ei tarkista
     * laudan sääntöjä.
     *
     * @param lahto Mistä halutaan siirtyä.
     * @param kohde Minne halutaan siirtyä.
     * @return Palauttaa tosi jos siirtyminen on mahdollista. Muuten epätosi.
     */
    abstract boolean okSiirtya(Sijainti lahto, Sijainti kohde);

    /**
     * Jokaisella nappulalla oma "kuva" joka toteutetaan
     *
     * @return Palauttaa nappulan "kuvan".
     */
    public abstract String piirra();

    /**
     * Tarkistetaan onko nappula sama kuin toinen nappula.
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (o.getClass() != this.getClass()) {
            return false;
        }
        return o.hashCode() == this.hashCode();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.sijainti);
        hash = 19 * hash + Objects.hashCode(this.tyyppi);
        hash = 19 * hash + (this.vari ? 1 : 0);
        return hash;
    }
}
