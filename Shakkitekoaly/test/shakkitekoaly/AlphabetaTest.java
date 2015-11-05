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
public class AlphabetaTest {
    
    Alphabeta l = new Alphabeta(new Lauta(), true, 2);
    
    @Test
    public void arviointiMuutos(){
        Nappula[] lauta = new Nappula[1];
        lauta[0] = new Torni(3, 3, true);
        int v = l.arvioiLauta(lauta);
        
        lauta = new Nappula[2];
        lauta[0] = new Torni(3, 3, true);
        lauta[1] = new Torni(3, 4, false);
        int j = l.arvioiLauta(lauta);
        
        assertTrue(v > j);
    }
}
