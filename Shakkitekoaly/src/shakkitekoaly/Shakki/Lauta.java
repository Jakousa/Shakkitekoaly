/**
 *
 * Lauta huolehtii nappuloista ja niiden siirtämisestä.
 */
package shakkitekoaly.Shakki;

import java.util.Arrays;
import shakkitekoaly.nappula.*;
import static shakkitekoaly.nappula.Tyyppi.*;

public class Lauta {

    private Nappula[] lauta;

    /**
     * Nappulat luodaan konstruktorin aikana.
     */
    public Lauta() {
        Nappula[] nappulat = new Nappula[16 * 2];
        alusta(nappulat);
        this.lauta = nappulat;
    }
    
    /**
     * Tehdessä uutta lautaa nappulat laitetaan shakissa perinteisille paikoille
     * Toimii konstruktorin apuna.
     * 
     * @param n Lauta jolle nappulat halutaan laittaa
     */
    
    private void alusta(Nappula[] n){
        int kohta = 0;
        kohta = alustusApu(0, false, kohta, n);
        kohta = alustusApu(1, false, kohta, n);
        kohta = alustusApu(7, true, kohta, n);
        alustusApu(6, true, kohta, n);
    }
    
    /**
     * Toinen konstruktori laudan kopiointia varten. Tätä käytetään hyödyksi
     * tekoälyn käydessä siirtoja läpi.
     * @param nappulat Nappulatilanne joka halutaan laudalle.
     */
    public Lauta(Nappula[] nappulat) {
        this.lauta = new Nappula[nappulat.length];
        
        for (int i = 0; i < lauta.length; i++) {
            Nappula n = nappulat[i];
            switch (n.getTyyppi()) {
                case SOTILAS: this.lauta[i] = new Sotilas(new Sijainti(
                n.getSijainti().getX(), n.getSijainti().getY()), n.getVari());
                    break;
                case KUNINGAS: this.lauta[i] = new Kuningas(new Sijainti(
                n.getSijainti().getX(), n.getSijainti().getY()), n.getVari());
                    break;
                case KUNINGATAR: this.lauta[i] = new Kuningatar(new Sijainti(
                n.getSijainti().getX(), n.getSijainti().getY()), n.getVari());
                    break;
                case LAHETTI: this.lauta[i] = new Lahetti(new Sijainti(
                n.getSijainti().getX(), n.getSijainti().getY()), n.getVari());
                    break;
                case RATSU: this.lauta[i] = new Ratsu(new Sijainti(
                n.getSijainti().getX(), n.getSijainti().getY()), n.getVari());
                    break;
                case TORNI: this.lauta[i] = new Torni(new Sijainti(
                n.getSijainti().getX(), n.getSijainti().getY()), n.getVari());
                    break;
            }
        }
    }
    
    /**
     * Asettaa laudalle nappulat
     * @param nappulaTilanne Nappulat listassa kuten ne halutaan laudalle
     */
    public void setNappulat(Nappula[] nappulaTilanne) {
        this.lauta = nappulaTilanne;
    }

    public Nappula[] getNappulat() {
        return this.lauta;
    }

    /**
     * 
     * 
     * Siirtää nappulan ja kutsuu syömistä.
     * 
     * @param n Nappula jota halutaan siirtää.
     * @param kohde Paikka johon nappula halutaan siirtää.
     * @return Palauttaa tosi jos nappula siirrettiin muuten false.
     *
     */
    public boolean siirraNappulaa(Nappula n, Sijainti kohde) {
            
        if (n.siirry(n.getSijainti(), kohde)
                && (n.getTyyppi() == RATSU || onkoReitti(n, kohde))) {
            int s = -1;
            for (int i = 0; i < lauta.length; i++) {
                Nappula nappula = lauta[i];
                if (nappula.getSijainti().equals(kohde)) {
                    if (nappula.getVari() == n.getVari() || 
                            (n.getTyyppi() == SOTILAS && 
                            n.getSijainti().getY() == nappula.getSijainti().getY())) {
                        return false;
                    }
                    s = i;
                    break;
                }
            }
            if (s != -1) {
                syo(s);
            }
            if (n.getTyyppi() == SOTILAS && 
                    kohde.getY() != n.getSijainti().getY() && 
                    s == -1) {
                return false;
            }
            n.setSijainti(kohde);
            return true;
        }
        return false;
    }

    /**
     * 
     * Selvittää onko siirtymisen tiellä muita nappuloita, ei käytetä ratsulle.
     * 
     * @param n Nappula jota halutaan siirtää.
     * @param kohde Kohde minne nappulaa yritetään siirtää.
     * @return palauttaa pystyykö reitillä siirtymään suoraan.
     *
     */
    public boolean onkoReitti(Nappula n, Sijainti kohde) {
        Sijainti uus = new Sijainti(kohde.getX(), kohde.getY());
        int x = n.getSijainti().getX();
        int y = n.getSijainti().getY();

        if (x < kohde.getX()) {
            uus.setX(kohde.getX() - 1);
        } else if (x > kohde.getX()) {
            uus.setX(kohde.getX() + 1);
        }
        if (y < kohde.getY()) {
            uus.setY(kohde.getY() - 1);
        } else if (y > kohde.getY()) {
            uus.setY(kohde.getY() + 1);
        }
        if (n.getSijainti().equals(uus)) {
            return true;
        }
        for (Nappula nappula : lauta) {
            if (nappula.getSijainti().equals(uus)) {
                return false;
            }
        }

        return onkoReitti(n, uus);
    }

    /**
     * 
     * Käytetään vain apuna konstruktorissa, täyttää rivin erilaisilla
     * nappuloilla tai sotilailla jos ei ole päätyrivi.
     * 
     * @param aloitusX Rivi jolle täytetään nappulat
     * @param vari Pelaaja jolle nappulat annetaan
     * @param kohta Kertoo mihin nappula tulee rivillä laittaa
     *
     */
    private int alustusApu(int aloitusX, boolean vari, int kohta, Nappula[] l) {
        int i = 0;
        if (aloitusX == 0 || aloitusX == 7) {
            l[kohta++] = new Torni(new Sijainti(aloitusX, i++), vari);
            l[kohta++] = new Ratsu(new Sijainti(aloitusX, i++), vari);
            l[kohta++] = new Lahetti(new Sijainti(aloitusX, i++), vari);
            l[kohta++] = new Kuningatar(new Sijainti(aloitusX, i++), vari);
            l[kohta++] = new Kuningas(new Sijainti(aloitusX, i++), vari);
            l[kohta++] = new Lahetti(new Sijainti(aloitusX, i++), vari);
            l[kohta++] = new Ratsu(new Sijainti(aloitusX, i++), vari);
            l[kohta++] = new Torni(new Sijainti(aloitusX, i++), vari);
        } else {
            for (i = 0; i < l.length / 4; i++) {
                l[kohta++] = new Sotilas(new Sijainti(aloitusX, i), vari);
            }
        }
        return kohta;
    }

    /**
     * Tulostaa laudan tilanteen.
     */
    public void piirraLauta() {
        char[][] piirros = new char[9][9];
        for (int i = 0; i < piirros.length; i++) {
            char[] piirro = piirros[i];
            for (int j = 0; j < piirro.length; j++) {
                piirro[j] = '#';
            }
        }
        for (int i = 0; i < lauta.length; i++) {
            Nappula nappula = lauta[i];
            int x = nappula.getSijainti().getX();
            int y = nappula.getSijainti().getY();
            piirros[x][y] = nappula.piirra();
        }
        for (int i = 0; i < piirros.length-1; i++) {
            char[] piirro = piirros[i];
            piirro[8] = (char) (i+48);
        }
        for (int i = 0; i < piirros[8].length-1; i++) {
            piirros[8][i] = (char) (i+97);
        }
        piirros[8][8] = '*';
        for (int i = 0; i < piirros.length; i++) {
            char[] piirro = piirros[i];
            for (int j = 0; j < piirro.length; j++) {
                System.out.print(piirro[j]);
            }
            System.out.println("");
        }
    }

    /**
     * 
     * Poistaa nappulan laudalta ja pienentää nappulalistaa
     * 
     * @param s Mistä kohdin lautaa poistetaan nappula
     *
     */
    private void syo(int s) { //Kirjoitetaan tarvittaessa omalla
        Nappula[] uus = new Nappula[lauta.length - 1];
        System.arraycopy(lauta, 0, uus, 0, s);
        System.arraycopy(lauta, s + 1, uus, s, lauta.length - s - 1);
        this.lauta = uus;
    }
}