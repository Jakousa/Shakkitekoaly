package shakkitekoaly.Shakki;

import java.util.Scanner;
import shakkitekoaly.nappula.*;

public class Pelaaja {

    private boolean pelaaja;
    private Scanner lukija;

    public Pelaaja(boolean vuorolla) {
        this.pelaaja = vuorolla;
        this.lukija = new Scanner(System.in);
    }

    public boolean getPelaaja() {
        return pelaaja;
    }

    public void teeValinta(Lauta l) {
        boolean loop = true;
        int x1 = -2;
        int x2 = -2;
        int y1 = -2;
        int y2 = -2;

        while (loop) {
            while (loop) {
                System.out.println("Minkä haluat siirtää. esim. C5");
                String mist = lukija.nextLine();
                mist = mist.toLowerCase();
                y1 = ((int) mist.charAt(0) - 97);
                x1 = ((int) mist.charAt(1) - 48);
                if (x1 > 7 || x1 < 0 || y1 < 0 || y1 > 7) {
                    System.out.println("Ei ole kentällä.");
                } else {
                    loop = false;
                }
            }
            loop = true;
            while (loop) {
                System.out.println("Minne haluat siirtää. esim. E7");
                String mihi = lukija.nextLine();
                mihi = mihi.toLowerCase();
                y2 = ((int) mihi.charAt(0) - 97);
                x2 = ((int) mihi.charAt(1) - 48);
                if (x2 > 7 || x2 < 0 || y2 < 0 || y2 > 7) {
                    System.out.println("Ei ole kentällä.");
                } else {
                    loop = false;
                }
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
