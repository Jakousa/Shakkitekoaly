/**
 * Shakkitekoaly luokassa.. Tällä hetkellä se aloittaa uuden Shakkipelin.
 *
 */
package shakkitekoaly;

import shakkitekoaly.Shakki.Lauta;
import shakkitekoaly.Shakki.Shakkipeli;
import shakkitekoaly.nappula.*;

public class Shakkitekoaly {

    public static void main(String[] args) {
//        Shakkipeli p = new Shakkipeli();
//        p.pelaa();
        Alphabeta simppeli = new Alphabeta(true, 2);

        Alphabeta tosifiksu = new Alphabeta(false, 4);
        Lauta l = null;
        Nappula[] nappulat = new Nappula[6];
        nappulat[0] = new Kuningas(new Sijainti(7, 7), false);
        nappulat[1] = new Torni(new Sijainti(2, 5), false);
        nappulat[2] = new Torni(new Sijainti(2, 3), false);
        nappulat[3] = new Torni(new Sijainti(1, 7), false);
        nappulat[4] = new Torni(new Sijainti(3, 6), false);
        nappulat[5] = new Kuningas(new Sijainti(0, 4), true);
        //nappulat[6] = new Torni(new Sijainti(7, 0), true);
        l = new Lauta(nappulat);
        /**
         * ####K###0 #######t1 ###t#t##2 ######t#3 ########4 ########5 ########6
         * T######k7 abcdefgh*
         */
        l.piirraLauta();
        System.out.println("");
        tosifiksu.teeSiirto(l);
        l.piirraLauta();
        System.out.println("");
        tosifiksu.teeSiirto(l);
        l.piirraLauta();
        System.out.println("");
        tosifiksu.teeSiirto(l);
        l.piirraLauta();
        System.out.println("");
        tosifiksu.teeSiirto(l);
        l.piirraLauta();
        System.out.println("");
        tosifiksu.teeSiirto(l);
        l.piirraLauta();
        System.out.println("");
    }
}
