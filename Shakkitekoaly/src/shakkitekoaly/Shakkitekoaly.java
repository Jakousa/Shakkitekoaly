package shakkitekoaly;

import shakkitekoaly.nappula.*;

public class Shakkitekoaly {

    public static void main(String[] args) {
        Lauta l = new Lauta();
        l.piirraLauta();
        l.siirraNappulaa(l.getLauta()[0], new Sijainti(1,0));
        System.out.println("");
        l.piirraLauta();
        l.siirraNappulaa(l.getLauta()[0], new Sijainti(2,0));
        System.out.println("");
        l.piirraLauta();
    }
}
