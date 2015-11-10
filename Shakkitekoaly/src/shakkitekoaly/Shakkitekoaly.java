/**
 * Shakkitekoaly luokassa..
 *
 */
package shakkitekoaly;

import shakkitekoaly.nappula.*;

public class Shakkitekoaly {

    public static void main(String[] args) {
        Alphabeta t = new Alphabeta(true, 3);
        Alphabeta v = new Alphabeta(false, 2);
        Lauta l = new Lauta();

        l.piirraLauta();
        while (t.arvioiLauta(l.getNappulat()) < 10000
                && t.arvioiLauta(l.getNappulat()) > -10000) {
            t.teeSiirto(l);
            v.teeSiirto(l);
            System.out.println("");
            l.piirraLauta();
            
            System.out.println("t: " + t.arvioiLauta(l.getNappulat()));
            System.out.println("v: " + v.arvioiLauta(l.getNappulat()));
        }
    }
}
