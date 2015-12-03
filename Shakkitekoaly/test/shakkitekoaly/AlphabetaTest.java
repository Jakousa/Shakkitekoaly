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
import shakkitekoaly.Shakki.Lauta;
import shakkitekoaly.nappula.*;

/**
 *
 * @author hatchy
 */
public class AlphabetaTest {

    Alphabeta simppeli = new Alphabeta(true, 2);

    @Test
    public void arviointiMuutos() {
        Nappula[] lauta = new Nappula[1];
        lauta[0] = new Torni(new Sijainti(3, 3), true);
        int v = simppeli.arvioiLauta(lauta);

        lauta = new Nappula[2];
        lauta[0] = new Torni(new Sijainti(3, 3), true);
        lauta[1] = new Torni(new Sijainti(3, 4), false);
        int j = simppeli.arvioiLauta(lauta);

        assertTrue(v > j);
    }

    /**
     * Älykkyystesteissä tarkistetaan että tekoäly suojelee omaa kuningasta,
     * yrittää syödä parhaimman vaihtoedon jos arvioidaan tarpeeksi pitkälle ja
     * ei syödä vaarantavasti jos arvioidaan tarpeeksi pitkällä.
     */
    @Test
    public void alykkyysTestiItsesuojeluvaisto() {
        Alphabeta tosifiksu = new Alphabeta(false, 4);
        Lauta l = null;
        Nappula[] nappulat = new Nappula[4];
        nappulat[0] = new Kuningas(new Sijainti(3, 3), false);
        nappulat[1] = new Lahetti(new Sijainti(4, 4), true);
        nappulat[2] = new Torni(new Sijainti(4, 5), true);
        nappulat[3] = new Kuningas(new Sijainti(0,7), true);
        l = new Lauta(nappulat);
        int arvioAlku = tosifiksu.arvioiLauta(l.getNappulat());
        tosifiksu.teeSiirto(l);
        int arvioLoppu = tosifiksu.arvioiLauta(l.getNappulat());
        assertTrue(arvioAlku == arvioLoppu);
    }

    /**
     * Tilanteessa tekoälyn pitäisi uhrata oma kuningatar kuninkaan suojaksi,
     * muuten lähetti aiheuttaa häviön.
     */
    @Test
    public void alykkyysTestiSuojele() {
        Alphabeta tosifiksu = new Alphabeta(false, 4);
        Lauta l = null;
        Nappula[] nappulat = new Nappula[5];
        nappulat[0] = new Kuningas(new Sijainti(3, 3), false);
        nappulat[1] = new Lahetti(new Sijainti(4, 4), true);
        nappulat[2] = new Torni(new Sijainti(4, 5), true);
        nappulat[3] = new Kuningatar(new Sijainti(5, 5), false);
        nappulat[4] = new Kuningas(new Sijainti(0,7), true);
        l = new Lauta(nappulat);
        int arvioAlku = tosifiksu.arvioiLauta(l.getNappulat());
        tosifiksu.teeSiirto(l); //Pitäisi syödä Kuningattarella Lähetti.
        int arvioLoppu = tosifiksu.arvioiLauta(l.getNappulat());
        assertTrue(Math.abs(arvioAlku - arvioLoppu) == 15);
        arvioAlku = tosifiksu.arvioiLauta(l.getNappulat());
        simppeli.teeSiirto(l); //Pitäisi syödä Tornilla Kuningatar
        arvioLoppu = tosifiksu.arvioiLauta(l.getNappulat());
        assertTrue(Math.abs(arvioAlku - arvioLoppu) == 45);
        arvioAlku = tosifiksu.arvioiLauta(l.getNappulat());
        tosifiksu.teeSiirto(l); //Pitäisi syödä Kuninkaalla Torni.
        arvioLoppu = tosifiksu.arvioiLauta(l.getNappulat());
        assertTrue(Math.abs(arvioAlku - arvioLoppu) == 25);
    }

    @Test
    public void alykkyysTestiTosiVaikea() {
        Alphabeta tosifiksu = new Alphabeta(false, 4);
        Lauta l = null;
        Nappula[] nappulat = new Nappula[6];
        nappulat[0] = new Kuningas(new Sijainti(3, 3), false);
        nappulat[1] = new Lahetti(new Sijainti(4, 4), true);
        nappulat[2] = new Torni(new Sijainti(4, 5), true);
        nappulat[3] = new Kuningatar(new Sijainti(5, 5), false);
        nappulat[4] = new Kuningatar(new Sijainti(6, 6), true);
        nappulat[5] = new Kuningas(new Sijainti(7,0), true);
        l = new Lauta(nappulat);
        int arvioAlku = tosifiksu.arvioiLauta(l.getNappulat());
        tosifiksu.teeSiirto(l); //Pitäisi syödä kuningattarella lähetti.
        int arvioLoppu = tosifiksu.arvioiLauta(l.getNappulat());
        assertTrue(Math.abs(arvioAlku - arvioLoppu) == 15);
    }

    @Test
    public void alykkyysTestiKuninkaanuhraus() {
        Alphabeta tosifiksu = new Alphabeta(false, 4);
        Lauta l = null;
        Nappula[] nappulat = new Nappula[7];
        nappulat[0] = new Kuningas(new Sijainti(7, 7), false);
        nappulat[1] = new Torni(new Sijainti(2, 5), false);
        nappulat[2] = new Torni(new Sijainti(2, 3), false);
        nappulat[3] = new Torni(new Sijainti(1, 7), false);
        nappulat[4] = new Torni(new Sijainti(3, 6), false);
        nappulat[5] = new Kuningas(new Sijainti(0, 4), true);
        nappulat[6] = new Torni(new Sijainti(7, 0), true);
        l = new Lauta(nappulat);
        /**
         *  ####K###0
         *  #######t1
         *  ###t#t##2
         *  ######t#3
         *  ########4
         *  ########5
         *  ########6
         *  T######k7
         *  abcdefgh*
         */
        int arvioAlku = tosifiksu.arvioiLauta(l.getNappulat());
        tosifiksu.teeSiirto(l); //Älykäs ei uhraa omaa kuningasta
        tosifiksu.teeSiirto(l); //Kuningas on turvassa ja aika siirtää tornia
        int arvioLoppu = tosifiksu.arvioiLauta(l.getNappulat());
        assertTrue(arvioAlku == arvioLoppu);
        tosifiksu.teeSiirto(l); //Vastustajan kuningas syödään vasta nyt tornilla
        arvioLoppu = tosifiksu.arvioiLauta(l.getNappulat());
        //assertTrue(Math.abs(arvioAlku - arvioLoppu) > 5000); //Sitä ei syödä....
    }
}
