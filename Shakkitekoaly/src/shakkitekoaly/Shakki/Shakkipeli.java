/**
 * Shakkipeli luokka ylläpitää shakkipeliä johon kuuluu lauta ja kaksi pelaajaa,
 * molemmat pelaajista voivat olla tekoälyjä tai toinen voi olla pelaaja.
 */

package shakkitekoaly.Shakki;

import java.util.Scanner;
import shakkitekoaly.Alphabeta;

public class Shakkipeli {

    private final Lauta lauta;
    private Alphabeta tekoaly1;
    private Alphabeta tekoaly2;
    private Pelaaja pelaaja;

    public Shakkipeli() {
        this.lauta = new Lauta();
        this.tekoaly1 = null;
        this.tekoaly2 = null;
        this.pelaaja = null;
    }

    /**
     * Kysyy kysymykset joita pelin alussa on tarpeellista kysyä käyttäjältä.
     */
    
    private void alkuKysely() {
        Scanner lukija = new Scanner(System.in);
        String ok = "S";
        while (!(ok.equalsIgnoreCase("Y") || ok.equalsIgnoreCase("N"))) {
            System.out.println("Haluatko pelata? Y/N");
            ok = lukija.nextLine();
        }
        String aloitus = "Y";
        if (ok.equalsIgnoreCase("Y")) {
            System.out.println("Haluatko aloittaa? Y/N");
            aloitus = lukija.nextLine();
            if (aloitus.equalsIgnoreCase("Y")) {
                this.pelaaja = new Pelaaja(true);
            } else {
                this.pelaaja = new Pelaaja(false);
            }
        } else {
            System.out.println("Minkä tasoinen VALKOINEN tekoäly? \n Suosittelen < 5");
            int vaikeustaso = Integer.parseInt(lukija.nextLine());
            tekoaly2 = new Alphabeta(true, vaikeustaso);
        }
        System.out.println("Minkä tasoinen toinen pelaaja? \n Suosittelen < 5");
        int syvyys = Integer.parseInt(lukija.nextLine());
        if (aloitus.equalsIgnoreCase("Y")) {
            tekoaly1 = new Alphabeta(false, syvyys);
        } else {
            tekoaly1 = new Alphabeta(true, syvyys);
        }
    }

    /**
     * Alkukysely kutsutaan jonka jälkeen looppi joka pyörii kunnes 
     * tekoälyn lauta-arvio sanoo että joku kuningas on syöty,
     * loopissa pyydetään tekoälyä tekemään siirto jonka jälkeen toista tekoälyä
     * tai pelaajaa pyydetään siirtämään riippuen aloittajasta.
     */
    public void pelaa() {
        alkuKysely();
        long kokoAika = System.currentTimeMillis();
        while (Math.abs(tekoaly1.arvioiLauta(lauta.getNappulat())) < 5000) {
            lauta.piirraLauta();
            System.out.println("Tekoälyn antama arvio: " + tekoaly1.arvioiLauta(lauta.getNappulat()));
            long aikaAlussa;
            long aikaLopussa;
            if (pelaaja == null) {
                aikaAlussa = System.currentTimeMillis();
                tekoaly2.teeSiirto(lauta);
                aikaLopussa = System.currentTimeMillis();
                lauta.piirraLauta();
                System.out.println("Aikaa kului: " + (aikaLopussa - aikaAlussa) + "ms.");
                System.out.println("Aikaa kokonaisuudessaan: " + (aikaLopussa - kokoAika) + "ms.");
            } else {
                if (pelaaja.getPelaaja()) {
                    pelaaja.teeValinta(lauta);
                    lauta.piirraLauta();
                }
            }
            aikaAlussa = System.currentTimeMillis();
            tekoaly1.teeSiirto(lauta);
            aikaLopussa = System.currentTimeMillis();
            lauta.piirraLauta();
            System.out.println("Aikaa kului: " + (aikaLopussa - aikaAlussa) + "ms.");
            System.out.println("Aikaa kokonaisuudessaan: " + (aikaLopussa - kokoAika) + "ms.");

            if (pelaaja != null) {
                if (!pelaaja.getPelaaja()) {
                    pelaaja.teeValinta(lauta);
                    lauta.piirraLauta();
                }
            }
        }
    }
}
