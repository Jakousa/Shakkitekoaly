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
import static shakkitekoaly.nappula.Tyyppi.*;

/**
 *
 * @author hatchy
 */
public class NappulaTest {
    
    @Test
    public void laudanRajat() {
        Nappula n = new Kuningatar(5,5,true);
        assertTrue(!(n.siirry(n.getSijainti(), new Sijainti(8,5))));
        assertTrue(!(n.siirry(n.getSijainti(), new Sijainti(5,8))));
        assertTrue(!(n.siirry(n.getSijainti(), new Sijainti(-1,5))));
        assertTrue(!(n.siirry(n.getSijainti(), new Sijainti(5,-1))));
        
//        assertTrue(n.siirry(n.getSijainti(), new Sijainti(5,0)));
//        assertTrue(n.siirry(n.getSijainti(), new Sijainti(0,5)));
//        assertTrue(n.siirry(n.getSijainti(), new Sijainti(5,7)));
//        assertTrue(n.siirry(n.getSijainti(), new Sijainti(7,5)));
        
    }
    @Test
    public void equalsTesti() {
        Nappula n = new Kuningas(0,0,true);
        Nappula m = new Kuningatar(0,0,true);
        Nappula h = new Kuningas(1,0,true);
        Nappula i = new Kuningas(0,1,true);
        Nappula j = new Kuningas(0,0,false);
        Nappula k = new Kuningas(0,0,true);
        
        assertTrue(!(n.equals(m)));
        assertTrue(!(n.equals(h)));
        assertTrue(!(n.equals(i)));
        assertTrue(!(n.equals(j)));
        assertTrue((n.equals(k)));
    }
    
}
