/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shakkitekoaly.nappula;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import shakkitekoaly.Lauta;

/**
 *
 * @author hatchy
 */
public class LahettiTest {
    
    Nappula l = new Lahetti(new Sijainti(4,4), true);

    
        @Test
    public void siirtyminenOikein() {
        assertTrue(!l.okSiirtya(l.getSijainti(), new Sijainti(3,4)));
        assertTrue(!l.okSiirtya(l.getSijainti(), new Sijainti(5,4)));
        assertTrue(!l.okSiirtya(l.getSijainti(), new Sijainti(4,3)));
        assertTrue(!l.okSiirtya(l.getSijainti(), new Sijainti(4,5)));
        assertTrue(l.okSiirtya(l.getSijainti(), new Sijainti(2,2)));
        assertTrue(l.okSiirtya(l.getSijainti(), new Sijainti(6,6)));
        assertTrue(l.okSiirtya(l.getSijainti(), new Sijainti(2,6)));
        assertTrue(l.okSiirtya(l.getSijainti(), new Sijainti(6,2)));
    }
    
        @Test
    public void piirtoOikein() {
        String s = null;
        s = l.piirra();
        assertTrue(s != null);
        Nappula vK = new Lahetti(new Sijainti(1,1), false);
        String h = null;
        h = vK.piirra();
        assertTrue(h != null);
        
        assertTrue(!h.equals(s));
    }
}
