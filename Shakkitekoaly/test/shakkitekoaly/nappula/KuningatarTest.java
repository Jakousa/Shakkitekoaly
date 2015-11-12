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
public class KuningatarTest {
    
    
        Nappula q = new Kuningatar(new Sijainti(4,4), true);
    
        @Test
    public void siirtyminenOikein() {
        assertTrue(q.okSiirtya(q.getSijainti(), new Sijainti(2,4)));
        assertTrue(q.okSiirtya(q.getSijainti(), new Sijainti(6,4)));
        assertTrue(q.okSiirtya(q.getSijainti(), new Sijainti(4,2)));
        assertTrue(q.okSiirtya(q.getSijainti(), new Sijainti(4,6)));
        assertTrue(q.okSiirtya(q.getSijainti(), new Sijainti(2,2)));
        assertTrue(q.okSiirtya(q.getSijainti(), new Sijainti(6,6)));
        assertTrue(q.okSiirtya(q.getSijainti(), new Sijainti(2,6)));
        assertTrue(q.okSiirtya(q.getSijainti(), new Sijainti(6,2)));
    }
    
    @Test
    public void piirtoOikein() {
        String s = null;
        s = q.piirra();
        assertTrue(s != null);
        Nappula vK = new Kuningas(new Sijainti(1,1), false);
        String h = null;
        h = vK.piirra();
        assertTrue(h != null);
        
        assertTrue(!h.equals(s));
    }
}
