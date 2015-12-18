package shakkitekoaly.Shakki;

import java.util.Scanner;
import shakkitekoaly.nappula.*;

/**
 * Pelaaja luokassa on pelaajalle kyselyjä ja se pitää yllä kummalla puolella
 * pelaaja on.
 */
public class Pelaaja {

    private final boolean pelaaja;
    private final Scanner lukija;

    /**
     * Pelaaja konstruktori vaatii pelaajan roolin.
     *
     * @param vuorolla Kummalla värillä pelaaja pelaa booleanina.
     */
    public Pelaaja(boolean vuorolla) {
        this.pelaaja = vuorolla;
        this.lukija = new Scanner(System.in);
    }

    /**
     * Palauttaa pelaajan värin.
     *
     * @return Pelaajan väri boolean arvona.
     */
    public boolean getPelaaja() {
        return pelaaja;
    }

    /**
     * Pelaajan vuorolla kysytään mitä pelaaja haluaisi siirtää ja koitetaan
     * tehdä se siirto.
     *
     * @param l Pelilauta jolla pelaaja tulee liikkumaan.
     */
    public void teeValinta(Lauta l) {
        boolean loop = true;
        int x1 = -2;
        int x2 = -2;
        int y1 = -2;
        int y2 = -2;

        while (loop) {
            while (loop) {
                System.out.println("Minkä haluat siirtää? esim. C5");
                String mist = lukija.nextLine();
                mist = mist.toLowerCase();
                if (mist.length() == 2) {
                    y1 = ((int) mist.charAt(0) - 97);
                    x1 = ((int) mist.charAt(1) - 48);
                    if (x1 < 8 && x1 >= 0 && y1 >= 0 && y1 < 8) {
                        loop = false;
                        break;
                    }
                }
                System.out.println("Ei ole kentällä.");

            }
            loop = true;
            while (loop) {
                System.out.println("Minne haluat siirtää? esim. E7");
                String mihi = lukija.nextLine();
                mihi = mihi.toLowerCase();
                if (mihi.length() == 2) {
                    y2 = ((int) mihi.charAt(0) - 97);
                    x2 = ((int) mihi.charAt(1) - 48);
                    if (x2 < 8 && x2 >= 0 && y2 >= 0 && y2 < 8) {
                        loop = false;
                        break;
                    }
                }
                System.out.println("Ei ole kentällä.");
            }
            Nappula n = null;
            for (Nappula nappula : l.getNappulat()) {
                if (nappula.getSijainti().equals(new Sijainti(x1, y1))) {
                    if (nappula.getVari() == pelaaja) {
                        n = nappula;
                        loop = true;
                    }
                }
            }
            if (loop == false) {
                System.out.println("Valitse nappula oikein.");
                loop = true;
                l.piirraLauta();
                continue;
            }
            loop = l.siirraNappulaa(n, new Sijainti(x2, y2));
            if (loop == false) {
                loop = true;
                System.out.println("Siirtäminen ei onnistunut, yritä uudelleen");
                l.piirraLauta();
            } else {
                break;
            }
        }
    }
}
