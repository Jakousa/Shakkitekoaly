package shakkitekoaly;

import shakkitekoaly.nappula.*;
import static shakkitekoaly.nappula.Tyyppi.*;

/**
 * 
 * @author hatchy
 * 
 * Lauta huolehtii nappuloista
 */
public class Lauta {

    private Nappula[] lauta;
    /**
     * Nappulat luodaan konstruktorin aikana
     */
    public Lauta() {
        lauta = new Nappula[16 * 2];
        alustusApu(0, false, 0);
        alustusApu(1, false, 8);
        alustusApu(7, true, 16);
        alustusApu(6, true, 24);
    }

    public Nappula[] getLauta() {
        return this.lauta;
    }
/**
 * @param n Nappula jota halutaan siirtää
 * @param kohde Paikka johon nappula halutaan siirtää
 * @return Palauttaa tosi jos nappula siirrettiin muuten false
 * 
 * Siirtää nappulan ja kutsuu syömistä
 * 
 */
    public boolean siirraNappulaa(Nappula n, Sijainti kohde) {
        if (n.getTyyppi() == SOTILAS) {
            //if ();
        }
        if (n.siirry(n.getSijainti(), kohde) && 
                (n.getTyyppi() == RATSU || onkoReitti(n, kohde))) {
            int s = -1;
            for (int i = 0; i < lauta.length; i++) {
                Nappula nappula = lauta[i];
                if (nappula.getSijainti().equals(kohde)) {
                    if (nappula.getVari() == n.getVari()) {
                        return false;
                    }
                    s = i;
                }
            }
            if (s != -1) {
                syo(s);
            }
            n.setSijainti(kohde);
        }
        return false;
    }

    /**
     * @param n Nappula jota halutaan siirtää
     * @param kohde Kohde minne nappulaa yritetään siirtää
     * @return palauttaa pystyykö reitillä siirtymään suoraan
     * 
     * Selvittää onko siirtymisen tiellä muita nappuloita, ei käytetä ratsulle
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
     * @param aloitusX Rivi jolle täytetään nappulat
     * @param vari Pelaaja jolle nappulat annetaan
     * @param kohta Kertoo mihin nappula tulee rivillä laittaa
     * 
     * Käytetään vain apuna konstruktorissa, täyttää rivin erilaisilla nappuloilla
     * tai sotilailla jos ei ole päätyrivi
     */
    private void alustusApu(int aloitusX, boolean vari, int kohta) {
        int i = 0;
        if (aloitusX == 0 || aloitusX == 7) {
            lauta[kohta++] = new Torni(aloitusX, i++, vari, TORNI);
            lauta[kohta++] = new Ratsu(aloitusX, i++, vari, RATSU);
            lauta[kohta++] = new Lahetti(aloitusX, i++, vari, LAHETTI);
            lauta[kohta++] = new Kuningatar(aloitusX, i++, vari, KUNINGATAR);
            lauta[kohta++] = new Kuningas(aloitusX, i++, vari, KUNINGAS);
            lauta[kohta++] = new Lahetti(aloitusX, i++, vari, LAHETTI);
            lauta[kohta++] = new Ratsu(aloitusX, i++, vari, RATSU);
            lauta[kohta++] = new Torni(aloitusX, i++, vari, TORNI);
        } else {
            for (i = 0; i < lauta.length / 4; i++) {
                lauta[kohta++] = new Sotilas(aloitusX, i, vari, SOTILAS);
            }
        }
    }

    /**
     * Tulostaa laudan tilanteen
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
     * @param s Mistä kohdin lautaa poistetaan nappula
     * 
     * Poistaa nappulan laudalta ja pienentää nappulalistaa
     */
    private void syo(int s) { //Kirjoitetaan tarvittaessa omalla
        Nappula[] uus = new Nappula[lauta.length - 1];
        System.arraycopy(lauta, 0, uus, 0, s);
        System.arraycopy(lauta, s + 1, uus, s, lauta.length - s - 1);
        this.lauta = uus;
    }
}
