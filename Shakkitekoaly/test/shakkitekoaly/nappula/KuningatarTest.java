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
public class KuningatarTest {

    Nappula q = new Kuningatar(new Sijainti(4, 4), true);

    @Test
    public void siirtyminenOikein() {
        assertTrue(q.okSiirtya(q.getSijainti(), new Sijainti(2, 4)));
        assertTrue(q.okSiirtya(q.getSijainti(), new Sijainti(6, 4)));
        assertTrue(q.okSiirtya(q.getSijainti(), new Sijainti(4, 2)));
        assertTrue(q.okSiirtya(q.getSijainti(), new Sijainti(4, 6)));
        assertTrue(q.okSiirtya(q.getSijainti(), new Sijainti(2, 2)));
        assertTrue(q.okSiirtya(q.getSijainti(), new Sijainti(6, 6)));
        assertTrue(q.okSiirtya(q.getSijainti(), new Sijainti(2, 6)));
        assertTrue(q.okSiirtya(q.getSijainti(), new Sijainti(6, 2)));
    }

    @Test
    public void piirtoOikein() {
        char s = '0';
        s = q.piirra();
        assertTrue(s != '0');
        Nappula vK = new Kuningas(new Sijainti(1, 1), false);
        char h = '0';
        h = vK.piirra();
        assertTrue(h != '0');

        assertTrue(!(h == s));
    }
}
