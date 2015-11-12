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
public class KuningasTest {
    
    Nappula k = new Kuningas(new Sijainti(4,4), true);
    
        @Test
    public void siirtyminenOikein() {
        assertTrue(k.okSiirtya(k.getSijainti(), new Sijainti(3,4)));
        assertTrue(k.okSiirtya(k.getSijainti(), new Sijainti(5,4)));
        assertTrue(k.okSiirtya(k.getSijainti(), new Sijainti(4,3)));
        assertTrue(k.okSiirtya(k.getSijainti(), new Sijainti(4,5)));
        assertTrue(k.okSiirtya(k.getSijainti(), new Sijainti(3,3)));
        assertTrue(k.okSiirtya(k.getSijainti(), new Sijainti(5,5)));
        assertTrue(k.okSiirtya(k.getSijainti(), new Sijainti(3,5)));
        assertTrue(k.okSiirtya(k.getSijainti(), new Sijainti(5,3)));
    }
    
    @Test
    public void piirtoOikein() {
        String s = null;
        s = k.piirra();
        assertTrue(s != null);
        Nappula vK = new Kuningas(new Sijainti(1,1), false);
        String h = null;
        h = vK.piirra();
        assertTrue(h != null);
        
        assertTrue(!h.equals(s));
    }
    
    
}
