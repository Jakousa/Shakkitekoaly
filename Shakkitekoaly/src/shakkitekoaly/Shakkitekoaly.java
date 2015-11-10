/**
 * Shakkitekoaly luokassa..
 *
 */
package shakkitekoaly;

import java.util.*;
import shakkitekoaly.nappula.*;

public class Shakkitekoaly {

    public static void main(String[] args) {
        Deque<Nappula[]> pino = new ArrayDeque<Nappula[]>();
        Lauta lauta = new Lauta();
        
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Nappula[] siirto = haeSiirto(new Sijainti(i, j), lauta, 11);
                if (siirto != null) {
                    pino.add(siirto);
                }
            }
        }
        for (Nappula[] pino1 : pino) {
            lauta.setNappulat(pino1);
            lauta.piirraLauta();
            System.out.println("");
        }
    }

    
    // Kopiointi....
    public static Nappula[] haeSiirto(Sijainti s, Lauta l, int listasta) {
        Nappula[] palautetaan = null;
        Lauta siirretty = new Lauta(l.getNappulat());
        if (siirretty.siirraNappulaa(siirretty.getNappulat()[listasta], s)) {
            palautetaan = siirretty.getNappulat();
        }
        return palautetaan;
    }
}
