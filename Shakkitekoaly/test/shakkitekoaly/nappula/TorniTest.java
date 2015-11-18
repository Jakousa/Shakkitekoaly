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
public class TorniTest {

    Nappula t = new Torni(new Sijainti(4, 4), true);

    @Test
    public void siirtyminenOikein() {
        assertTrue(t.okSiirtya(t.getSijainti(), new Sijainti(2,4)));
        assertTrue(t.okSiirtya(t.getSijainti(), new Sijainti(6,4)));
        assertTrue(t.okSiirtya(t.getSijainti(), new Sijainti(4,2)));
        assertTrue(t.okSiirtya(t.getSijainti(), new Sijainti(4,6)));
    }

    @Test
    public void piirtoOikein() {
        char s = '0';
        s = t.piirra();
        assertTrue(s != '0');
        Nappula vK = new Torni(new Sijainti(1, 1), false);
        char h = '0';
        h = vK.piirra();
        assertTrue(h != '0');

        assertTrue(!(h == s));
    }
}
