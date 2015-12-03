/**
 * Luokka määrittelee alpha-beta algoritmin ja pystyy tekemään arvion laudan
 * tilanteesta sekä siirtää nappulaa sen mukaan.
 *
 */
package shakkitekoaly;

import shakkitekoaly.Shakki.Lauta;
import java.util.Arrays;
import shakkitekoaly.nappula.Nappula;
import shakkitekoaly.nappula.Sijainti;

public class Alphabeta {

    private int montaSiirtoa;
    private final boolean pelaaja;
    private int parasSyvyys;

    /**
     *
     * @param pelaaja Pelaaja jonka vuorolla Alphabeta pelaa.
     * @param syvyys Kuinka monta vuoroa eteenpäin algoritmi arvioi.
     */
    public Alphabeta(boolean pelaaja, int syvyys) {
        this.pelaaja = pelaaja;
        this.montaSiirtoa = syvyys;
    }

    public boolean getPelaaja() {
        return pelaaja;
    }

    /**
     * Tekoäly tekeen siirron. Käy läpi jokaisen nappulan paikan (ensimmäinen
     * syvyys) jonka jälkeen kutsuu alphaBetalta arviota siirrosta ja tekee
     * parhaimman siirron
     *
     * @param l
     */
    public void teeSiirto(Lauta l) {
        Nappula[] parasSiirto = null;
        int parasArvio = Integer.MIN_VALUE;

        for (Nappula n : l.getNappulat()) {
            if (n.getVari() == this.pelaaja) {
                for (Nappula[] nappulanSiirrot : nappulanSiirrot(n, l.getNappulat())) {
                    int uusiArvio = this.alphaBeta(nappulanSiirrot,
                            Integer.MIN_VALUE, Integer.MAX_VALUE,
                            montaSiirtoa - 1, !pelaaja);
                    if (parasArvio < uusiArvio) {
                        parasArvio = uusiArvio;
                        parasSiirto = nappulanSiirrot;
                    }
                }
            }
        }
        if (parasSiirto == null) {
            System.out.println("Jotain meni vikaan");
        } else {
            l.setNappulat(parasSiirto);
        }
    }

    /**
     * Arvioi laudan mahdollisia siirtoja Alpha-beta algoritmin mukaan
     *
     * @param nappulat Laudan tilanne
     * @param alpha
     * @param beta
     * @param syvyys Kuinka monta siirtoa etsitään
     * @param vuorossa Pelaaja jonka vuoro on
     * @return Palauttaa parhaimman arvion
     */
    public int alphaBeta(Nappula[] nappulat, int alpha, int beta,
            int syvyys, boolean vuorossa) {
        int tilanne = arvioiLauta(nappulat);
        if (syvyys == 0 || Math.abs(tilanne) > 5000) {
            return tilanne;
        }
        if (vuorossa == pelaaja) {
            int v = Integer.MIN_VALUE;
            for (Nappula n : nappulat) {
                if (n.getVari() == pelaaja) {
                    for (Nappula[] nappulanSiirrot : nappulanSiirrot(n, nappulat)) {
                        v = Math.max(v, alphaBeta(nappulanSiirrot, alpha, beta, syvyys - 1, !vuorossa));
                        alpha = Math.max(alpha, v);
                        if (beta <= alpha) {
                            return v;
                        }
                    }
                }
            }
            return v;
        } else {
            int v = Integer.MAX_VALUE;
            for (Nappula n : nappulat) {
                if (n.getVari() != pelaaja) {
                    for (Nappula[] nappulanSiirrot : nappulanSiirrot(n, nappulat)) {
                        v = Math.min(v, alphaBeta(nappulanSiirrot, alpha, beta, syvyys - 1, !vuorossa));
                        alpha = Math.min(alpha, v);
                        if (beta <= alpha) {
                            return v;
                        }
                    }
                }
            }
            return v;
        }
    }

    /**
     * Arvioi laudan ja antaa tilanteesta algoritmille arvion Palauttaa suuren
     * luvun jos tilanne arvioidaan hyväksi ja pienemmän jos tilanne on
     * huonompi. Nappuloiden arvoja olisi hyvä muokata vielä.
     *
     * @param l Lista nappuloita eli laudan tilanne jota halutaan arvioida
     * @return palauttaa tehdyn arvion laudasta kokonaislukuna
     */
    public int arvioiLauta(Nappula[] l) {
        int v = 0;
        for (Nappula nappula : l) {
            int kerroin = 1;
            if (nappula.getVari() != pelaaja) {
                kerroin = -1;
            }
            switch (nappula.getTyyppi()) {
                case SOTILAS:
                    v = v + (kerroin * 5);
                    break;
                case LAHETTI:
                    v = v + (kerroin * 15);
                    break;
                case RATSU:
                    v = v + (kerroin * 15);
                    break;
                case TORNI:
                    v = v + (kerroin * 25);
                    break;
                case KUNINGATAR:
                    v = v + (kerroin * 45);
                    break;
                case KUNINGAS:
                    v = v + (kerroin * 10000);
                    break;
            }
        }
        return v;
    }

    /**
     * Käy läpi nappulan siirrot kutsumalla haeSiirrot mahdolliselle siirrolle
     * ja lisää pinoon jos siirto oli olemassa. Ei käytetä kuin alphaBetassa.
     *
     * @param sijaintiLaudalla Nappulan sijainti nappulalistassa
     * @param n Nappulalista
     * @return Palauttaa pinon mahdollisia siirtoja nappulalle
     */
    private Nappula[][] nappulanSiirrot(Nappula n, Nappula[] nappulat) {
        Nappula[][] vali;
        Nappula[][] pino = new Nappula[0][nappulat.length];
        for (Sijainti mahdollisuus : n.mahdollisetSiirtymat()) {
            Nappula[] siirto = haeSiirto(mahdollisuus, nappulat, n);
            if (siirto != null) {
                vali = Arrays.copyOf(pino, pino.length + 1);
                vali[pino.length] = new Nappula[siirto.length];
                for (int k = 0; k < siirto.length; k++) {
                    vali[pino.length][k] = siirto[k];
                }
                pino = Arrays.copyOf(vali, vali.length);
            }
        }
        return pino;
    }

    /**
     * Tarkistaa onko siirto mahdollinen. Ei käytetä kuin nappulanSiirron apuna
     *
     * @param s Sijainti laudalla josta nappulaa halutaan siirtää
     * @param nappulat Laudalla olevien nappuloiden lista
     * @param sijaintiLaudalla Nappulan sijainti nappulat jonossa
     * @return Palauttaa uuden tilanteen nappulat jos siirto oli mahdollinen
     */
    private Nappula[] haeSiirto(Sijainti s, Nappula[] nappulat, Nappula n) {
        Nappula[] palautetaan = null;
        Lauta siirretty = new Lauta(nappulat);
        for (Nappula n1 : siirretty.getNappulat()) {
            if (n1.equals(n)) {
                if (siirretty.siirraNappulaa(n1, s)) {
                    palautetaan = siirretty.getNappulat();
                }
                break;
            }
        }
        return palautetaan;
    }
}
