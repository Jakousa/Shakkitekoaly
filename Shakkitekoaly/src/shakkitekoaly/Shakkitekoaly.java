package shakkitekoaly;

import shakkitekoaly.nappula.*;

public class Shakkitekoaly {

    public static void main(String[] args) {
        Lauta l = new Lauta();
        l.piirraLauta();
        l.siirraNappulaa(l.getLauta()[8], new Sijainti(2,0));
        System.out.println("");
        l.piirraLauta();
        l.siirraNappulaa(l.getLauta()[8], new Sijainti(3,0));
        System.out.println("");
        l.piirraLauta();
        
        for (int i = 0; i < 6; i++) {
            l.siirraNappulaa(l.getLauta()[8], new Sijainti(i,0));
            System.out.println("");
            l.piirraLauta();
        }
        l.siirraNappulaa(l.getLauta()[8], new Sijainti(6,1));
        System.out.println("");
        l.piirraLauta();
    }
}
