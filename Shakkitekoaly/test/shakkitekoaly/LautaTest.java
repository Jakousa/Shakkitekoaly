/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shakkitekoaly;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import shakkitekoaly.nappula.*;

/**
 *
 * @author hatchy
 */
public class LautaTest {

    Lauta l = new Lauta();

    @Test
    public void tyhjaLautaAlustetaanOikein() {
        assertTrue(l.getNappulat().length == (8 * 4));
    }

    @Test
    public void laudanKopiointiTesti() {
        Lauta h = new Lauta();

        Nappula[] nappulat = new Nappula[2];
        nappulat[0] = new Kuningas(new Sijainti(3, 3), true);
        nappulat[1] = new Kuningas(new Sijainti(5, 5), false);

        h = new Lauta(nappulat);
        nappulat[0].setSijainti(new Sijainti(0, 0));
        nappulat[1].setSijainti(new Sijainti(1, 1));

        assertTrue(h.getNappulat().length == 2);
        for (int i = 0; i < nappulat.length; i++) {
            assertTrue(nappulat[i] != h.getNappulat()[0]);
            assertTrue(nappulat[i] != h.getNappulat()[1]);
        }

    }

    @Test
    public void nappuloidenSiirtoTesti() {
        Nappula n = new Kuningatar(new Sijainti(4, 4), true);
        Sijainti uusi = new Sijainti(5, 5);
        Nappula[] nappulat = new Nappula[1];
        nappulat[0] = n;
        Lauta h = new Lauta(nappulat);
        h.siirraNappulaa(n, new Sijainti(5, 5));

        assertTrue(n.getSijainti().equals(uusi));
    }

    @Test
    public void nappuloidenSyontiTesti() {
        Nappula n = new Kuningatar(new Sijainti(4, 4), true);
        Nappula m = new Kuningatar(new Sijainti(4, 6), false);
        Nappula[] nappulat = new Nappula[2];
        nappulat[0] = n;
        nappulat[1] = m;
        Lauta s = new Lauta(nappulat);
        
        assertTrue(s.getNappulat().length == 2);
        boolean tosi = s.siirraNappulaa(m, n.getSijainti());
        boolean myostosi = n.getSijainti() == m.getSijainti();
        assertTrue(tosi);
        assertTrue(myostosi);
        assertTrue(s.getNappulat().length == 1);
    }
    
    @Test
    public void omanSyontiTesti() {
        Nappula n = new Kuningatar(new Sijainti(4, 4), true);
        Nappula m = new Kuningatar(new Sijainti(4, 6), true);
        Nappula[] nappulat = new Nappula[2];
        nappulat[0] = n;
        nappulat[1] = m;
        Lauta s = new Lauta(nappulat);
        
        boolean epatosi = s.siirraNappulaa(m, n.getSijainti());
        assertTrue(!epatosi);
    }

    @Test
    public void sotilaidenSiirtojaSyonti() {
        Nappula sV = new Sotilas(new Sijainti(2, 3), false);
        Nappula s = new Sotilas(new Sijainti(4, 4), true);
        Nappula[] nappulat = new Nappula[2];
        nappulat[0] = s;
        nappulat[1] = sV;
        
        Lauta h = new Lauta(nappulat);

        
        assertTrue(!(h.siirraNappulaa(sV, new Sijainti(2,2))));
        assertTrue(h.siirraNappulaa(sV, new Sijainti(3,3)));
        assertTrue(h.getNappulat().length == 2);
        assertTrue(h.siirraNappulaa(sV, new Sijainti(4,4)));
        assertTrue(h.getNappulat().length == 1);
    }
    
    @Test
    public void reitinLoyto() {
        Nappula n = new Kuningatar(new Sijainti(2, 2), true);
        Nappula m = new Kuningatar(new Sijainti(3, 3), false);
        Nappula[] nappulat = new Nappula[2];
        nappulat[0] = n;
        nappulat[1] = m;
        Lauta s = new Lauta(nappulat);

        boolean eitosi = s.siirraNappulaa(m, new Sijainti(1, 1));
        boolean eimyoskaan = m.getSijainti().equals(new Sijainti(1, 1));
        assertTrue(!eitosi);
        assertTrue(!eimyoskaan);
        assertTrue(m.getSijainti().equals(new Sijainti(3, 3)));
        
        assertTrue(s.getNappulat().length == 2);
    }
}
