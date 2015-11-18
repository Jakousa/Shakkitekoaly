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
import shakkitekoaly.Shakki.Lauta;

/**
 *
 * @author hatchy
 */
public class SijaintiTest {
    
    Sijainti s = new Sijainti(4,4);
    
    @Test
    public void setteriTesti() {
        assertTrue(s.getX() == 4);
        assertTrue(s.getY() == 4);
        s.setX(6);
        assertTrue(s.getX() == 6);
        s.setY(1);
        assertTrue(s.getY() == 1);
    }
    
    @Test
    public void equalsTesti() {
        Sijainti d = new Sijainti(4,4);
        Sijainti w = new Sijainti(3,4);
        Sijainti v = new Sijainti(4,3);
        
        assertTrue(s.equals(d));
        assertTrue(!(s.equals(w)));
        assertTrue(!(s.equals(v)));
        assertTrue(!(s.equals(new Lauta())));
    }
    
}
