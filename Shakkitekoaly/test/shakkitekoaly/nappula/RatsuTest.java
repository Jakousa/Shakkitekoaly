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
public class RatsuTest {
    
    Nappula r = new Ratsu(new Sijainti(4,4), true);
    
    @Test
    public void siirtyminenOikein() {
        assertTrue(r.okSiirtya(r.getSijainti(), new Sijainti(5,6)));
        assertTrue(r.okSiirtya(r.getSijainti(), new Sijainti(5,2)));
        assertTrue(r.okSiirtya(r.getSijainti(), new Sijainti(3,6)));
        assertTrue(r.okSiirtya(r.getSijainti(), new Sijainti(3,2)));
        assertTrue(r.okSiirtya(r.getSijainti(), new Sijainti(6,5)));
        assertTrue(r.okSiirtya(r.getSijainti(), new Sijainti(2,5)));
        assertTrue(r.okSiirtya(r.getSijainti(), new Sijainti(6,3)));
        assertTrue(r.okSiirtya(r.getSijainti(), new Sijainti(2,3)));
    }
    
        @Test
    public void piirtoOikein() {
        String s = null;
        s = r.piirra();
        assertTrue(s != null);
        Nappula vK = new Ratsu(new Sijainti(1,1), false);
        String h = null;
        h = vK.piirra();
        assertTrue(h != null);
        
        assertTrue(!h.equals(s));
    }
}
