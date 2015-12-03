
package shakkitekoaly.nappula;

import java.util.Objects;

/**
 * Abstrakti luokka pitää sisällään metodeja kuten siirtmistarkastelua jotka
 * muuten täytyisi toistaa jokaiselle (6) nappulalle erikseen.
 *
 * Sisältää sijainnin, nappulan tyypin ja värin.
 */
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

    /**
     * Palauttaa nappulan tyypin.
     * @return Nappulan tyyppi.
     */
    public Tyyppi getTyyppi() {
        return tyyppi;
    }

    /**
     * Palauttaa kumman puolelle nappula kuuluu.
     * @return Boolean arvona nappulan värin.
     */
    public boolean getVari() {
        return vari;
    }

    /**
     * Palauttaa nappulan sijainnin.
     * @return Sijainti-oliona nappulan sijainti laudalla.
     */
    public Sijainti getSijainti() {
        return sijainti;
    }

    /**
     * Asettaa tai siirtää nappulaa laudalla.
     * @param s Sijainti jossa nappulan halutaan sijaitsevan.
     */
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
     * Kertoo suoraan mahdolliset paikat nappulan sääntöjen mukaan.
     * @return Palauttaa paikat joinne siirtyminen on mahdollista.
     */
    public abstract Sijainti[] mahdollisetSiirtymat();
    
    /**
     * Jokaisella nappulalla oma "kuva" joka toteutetaan
     *
     * @return Palauttaa nappulan "kuvan".
     */
    public abstract char piirra();

    /**
     * Tarkistetaan onko nappula sama kuin toinen nappula.
     *
     * @param o Verrattava nappula.
     * @return Tosi jos nappula on saman värinen, samaa tyyppiä ja sijaitsee samassa paikassa.
     */
    @Override
    public boolean equals(Object o) {
        if (o.getClass() != this.getClass()) {
            return false;
        }
        return o.hashCode() == this.hashCode();
    }

    /**
     * Nappulan hashcode luodaan käyttämällä sijaintia, tyyppiä ja väriä.
     * @return Palauttaa kokonaisluvun joka riippuu sijainnista, tyypistä ja väristä.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.sijainti);
        hash = 19 * hash + Objects.hashCode(this.tyyppi);
        hash = 19 * hash + (this.vari ? 1 : 0);
        return hash;
    }
}
