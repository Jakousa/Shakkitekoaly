/**
 *
 * Luokka määrittelee alpha-beta algoritmin ja tekee siirron sen mukaan.
 * 
 */

package shakkitekoaly;

import shakkitekoaly.nappula.Nappula;

public class Alphabeta {

    private Lauta lauta;
    private int syvyys;
    private boolean pelaaja;

    public Alphabeta(Lauta lauta, boolean pelaaja, int syvyys) {
        this.lauta = lauta;
        this.pelaaja = pelaaja;
        this.syvyys = syvyys;
    }

    public Lauta getLauta() {
        return lauta;
    }

    public boolean isPelaaja() {
        return pelaaja;
    }
    
    
    
    /**
     * Siirtää nappulaa laudalla tekemänsä arvion mukaan
     * 
     */
    public void teeSiirto() {
        
    }

    /**
     * Arvioi laudan ja antaa tilanteesta algoritmille arvion
     * Palauttaa suuren luvun jos tilanne arvioidaan hyväksi ja pienemmän jos
     * tilanne on huonompi.
     * 
     * @param l Lista nappuloita eli lauta jota halutaan arvioida
     * @return palauttaa tehdyn arvion laudasta kokonaislukuna
     */
    public int arvioiLauta(Nappula[] l) {
        int v = 0;
        for (Nappula nappula : l) {
            int kerroin = 1;
            if (nappula.getVari() != pelaaja) {
                kerroin = -1;
            }
            switch (nappula.getTyyppi()) {
                case SOTILAS:   v = v + (kerroin * 5);
                                break;
                case LAHETTI:   v = v + (kerroin * 15);
                                break;
                case RATSU:     v = v + (kerroin * 15);
                                break;
                case TORNI:     v = v + (kerroin * 20);
                                break;
                case KUNINGATAR:v = v + (kerroin * 40);
                                break;
                case KUNINGAS:  v = (kerroin * Integer.MAX_VALUE);
                                break;
            }
        }
        return v;
    }
}
