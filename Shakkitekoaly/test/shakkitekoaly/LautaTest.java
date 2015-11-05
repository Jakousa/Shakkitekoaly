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

/**
 *
 * @author hatchy
 */
public class LautaTest {
    
    Lauta l = new Lauta();
    
    @Test
    public void alustetaanOikein(){
        assertTrue(l.getNappulat().length == (8*4));
    }
    
    
}
