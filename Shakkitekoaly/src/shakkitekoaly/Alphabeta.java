/**
 *
 * Luokka määrittelee alpha-beta algoritmin ja tekee siirron sen mukaan.
 * 
 */

package shakkitekoaly;

import java.util.ArrayDeque;
import java.util.Deque;
import shakkitekoaly.nappula.*;

public class Alphabeta {

    private int syvyys;
    private boolean pelaaja;

    public Alphabeta(boolean pelaaja, int syvyys) {
        this.pelaaja = pelaaja;
        this.syvyys = syvyys;
    }

    public boolean isPelaaja() {
        return pelaaja;
    }
    
    /**
     * Siirtää nappulaa laudalla tekemänsä arvion mukaan
     * 
     * @param lauta
     * @param alpha
     * @param beta
     * @param syvyys
     * @param vuorossa
     * @return 
     */
    public int alphaBeta(Nappula[] nappulat, int alpha, int beta, 
            int syvyys, boolean vuorossa) {
        int tilanne = arvioiLauta(nappulat);
        if (syvyys == 0 || 
                tilanne == Integer.MAX_VALUE || tilanne == Integer.MIN_VALUE) {
            return tilanne;
        }
        if (vuorossa) { // Ehkä pitäisi olla vuorossa == pelaaja
            int v = Integer.MIN_VALUE;
            for (int i = 0; i < nappulat.length; i++) {
                Nappula n = nappulat[i];
                if (n.getVari() == vuorossa) {
                    for (Nappula[] nappulanSiirrot : nappulanSiirrot(i, nappulat)) {
                        v = Math.max(v, arvioiLauta(nappulanSiirrot));
                        alpha = Math.max(alpha, v);
                        if (beta <= alpha) {
                            return v;
                        }
                    }
                }
            }
        } else {
            int v = Integer.MAX_VALUE;
            for (int i = 0; i < nappulat.length; i++) {
                Nappula n = nappulat[i];
                if (n.getVari() != vuorossa) {
                    for (Nappula[] nappulanSiirrot : nappulanSiirrot(i, nappulat)) {
                        v = Math.min(v, arvioiLauta(nappulanSiirrot));
                        alpha = Math.min(alpha, v);
                        if (beta <= alpha) {
                            return v;
                        }
                    }
                }
            }
        }
        return 0;
    }

    /**
     * Arvioi laudan ja antaa tilanteesta algoritmille arvion
     * Palauttaa suuren luvun jos tilanne arvioidaan hyväksi ja pienemmän jos
     * tilanne on huonompi.
     * 
     * @param l Lista nappuloita eli laudan tilanne jota halutaan arvioida
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

    private Deque<Nappula[]> nappulanSiirrot(int sijaintiLaudalla, Nappula[] n){
        Deque<Nappula[]> pino = new ArrayDeque<Nappula[]>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Nappula[] siirto = haeSiirto(new Sijainti(i, j), n, sijaintiLaudalla);
                if (siirto != null) {
                    pino.add(siirto);
                }
            }
        }
        return pino;
    }
    
    private Nappula[] haeSiirto(Sijainti s, Nappula[] nappulat, int sijaintiLaudalla) {
        Nappula[] palautetaan = null;
        Lauta siirretty = new Lauta(nappulat);
        if (siirretty.siirraNappulaa(siirretty.getNappulat()[sijaintiLaudalla], s)) {
            palautetaan = siirretty.getNappulat();
        }
        return palautetaan;
    }
}
