/**
 * Shakkitekoaly luokassa..
 *
 */
package shakkitekoaly;

import shakkitekoaly.nappula.*;

public class Shakkitekoaly {

    public static void main(String[] args) {

        Alphabeta l = new Alphabeta(new Lauta(), true, 2);

        Nappula[] lauta = new Nappula[1];
        lauta[0] = new Torni(3, 3, true);
        int v = l.arvioiLauta(lauta);
        lauta = new Nappula[2];
        lauta[0] = new Torni(3, 3, true);
        lauta[1] = new Torni(3, 4, false);
        int j = l.arvioiLauta(lauta);
        System.out.println(v + " = v  ja j = " + j);
    }
}
