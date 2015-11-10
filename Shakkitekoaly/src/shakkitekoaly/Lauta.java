/**
 *
 * Lauta huolehtii nappuloista ja niiden siirtämisestä.
 */
package shakkitekoaly;

import java.util.Arrays;
import shakkitekoaly.nappula.*;
import static shakkitekoaly.nappula.Tyyppi.*;

public class Lauta {

    private Nappula[] lauta;

    /**
     * Nappulat luodaan konstruktorin aikana.
     */
    public Lauta() {
        lauta = new Nappula[16 * 2];
        alustusApu(0, false, 0);
        alustusApu(1, false, 8);
        alustusApu(7, true, 16);
        alustusApu(6, true, 24);
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
    private void alustusApu(int aloitusX, boolean vari, int kohta) {
        int i = 0;
        if (aloitusX == 0 || aloitusX == 7) {
            lauta[kohta++] = new Torni(new Sijainti(aloitusX, i++), vari);
            lauta[kohta++] = new Ratsu(new Sijainti(aloitusX, i++), vari);
            lauta[kohta++] = new Lahetti(new Sijainti(aloitusX, i++), vari);
            lauta[kohta++] = new Kuningatar(new Sijainti(aloitusX, i++), vari);
            lauta[kohta++] = new Kuningas(new Sijainti(aloitusX, i++), vari);
            lauta[kohta++] = new Lahetti(new Sijainti(aloitusX, i++), vari);
            lauta[kohta++] = new Ratsu(new Sijainti(aloitusX, i++), vari);
            lauta[kohta++] = new Torni(new Sijainti(aloitusX, i++), vari);
        } else {
            for (i = 0; i < lauta.length / 4; i++) {
                lauta[kohta++] = new Sotilas(new Sijainti(aloitusX, i), vari);
            }
        }
    }

    /**
     * Tulostaa laudan tilanteen.
     */
    public void piirraLauta() {
        String[][] piirros = new String[8][8];
        for (int i = 0; i < piirros.length; i++) {
            String[] piirro = piirros[i];
            for (int j = 0; j < piirro.length; j++) {
                piirro[j] = "#";
            }
        }
        for (int i = 0; i < lauta.length; i++) {
            Nappula nappula = lauta[i];
            int x = nappula.getSijainti().getX();
            int y = nappula.getSijainti().getY();
            piirros[x][y] = nappula.piirra();
        }
        for (int i = 0; i < piirros.length; i++) {
            String[] piirro = piirros[i];
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
