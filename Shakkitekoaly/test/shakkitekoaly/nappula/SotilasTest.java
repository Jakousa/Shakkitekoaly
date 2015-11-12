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

/**
 *
 * @author hatchy
 */
public class SotilasTest {
    
    Nappula s = new Sotilas(new Sijainti(3,3), true);
    Nappula sV = new Sotilas(new Sijainti(4,4), false);
    
        @Test
    public void siirtyminenOikein() {
        assertTrue(s.okSiirtya(s.getSijainti(), new Sijainti(2,2)));
        assertTrue(s.okSiirtya(s.getSijainti(), new Sijainti(2,3)));
        assertTrue(s.okSiirtya(s.getSijainti(), new Sijainti(2,4)));
        
        assertTrue(sV.okSiirtya(sV.getSijainti(), new Sijainti(5,3)));
        assertTrue(sV.okSiirtya(sV.getSijainti(), new Sijainti(5,4)));
        assertTrue(sV.okSiirtya(sV.getSijainti(), new Sijainti(5,5)));
    }
    
        @Test
    public void piirtoOikein() {
        String st = null;
        st = s.piirra();
        assertTrue(st != null);
        Nappula vK = new Sotilas(new Sijainti(1,1), false);
        String h = null;
        h = vK.piirra();
        assertTrue(h != null);
        
        assertTrue(!h.equals(st));
    }
}
