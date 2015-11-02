package shakkitekoaly;

import shakkitekoaly.nappula.*;
import static shakkitekoaly.nappula.Tyyppi.*;

public class Lauta {

    private Nappula[] lauta;

    public Lauta() {
        lauta = new Nappula[16 * 2];
        alustusApu(0, false, 0);
        alustusApu(1, false, 8);
        alustusApu(7, true, 16);
        alustusApu(6, true, 24);
    }
    
    public Nappula[] getLauta(){
        return this.lauta;
    }

    public boolean siirraNappulaa(Nappula n, Sijainti kohde) {
        if (n.siirry(n.getSijainti(), kohde)) {
            if(n.getTyyppi() != RATSU) {
                onkoReitti(n, kohde);
            }
            
            int s = -1;
            for (int i = 0; i < lauta.length; i++) {
                Nappula nappula = lauta[i];
                if (nappula.getSijainti().equals(kohde)) {
                    if (nappula.getVari() == n.getVari()) {
                        return false;
                    }
                    s = i;
                }
            }
            if (s != -1) {
                syo(s);
            }
            n.setSijainti(kohde);
        }
        return false;
    }
    
    public boolean onkoReitti(Nappula n, Sijainti kohde) {
       Sijainti uus = new Sijainti(0,0);
       //Kesken
        for (Nappula nappula : lauta) {
            if (nappula.getSijainti().equals(uus)) {
                return false;
            }
        }
        return onkoReitti(n, uus);
    }

    private void alustusApu(int aloitusX, boolean vari, int kohta) {
        int i = 0;
        if (aloitusX == 0 || aloitusX == 7) {
            lauta[kohta++] = new Torni(aloitusX, i++, vari, TORNI);
            lauta[kohta++] = new Ratsu(aloitusX, i++, vari, RATSU);
            lauta[kohta++] = new Lahetti(aloitusX, i++, vari, LAHETTI);
            lauta[kohta++] = new Kuningatar(aloitusX, i++, vari, KUNINGATAR);
            lauta[kohta++] = new Kuningas(aloitusX, i++, vari, KUNINGAS);
            lauta[kohta++] = new Lahetti(aloitusX, i++, vari, LAHETTI);
            lauta[kohta++] = new Ratsu(aloitusX, i++, vari, RATSU);
            lauta[kohta++] = new Torni(aloitusX, i++, vari, TORNI);
        } else {
            for (i = 0; i < lauta.length / 4; i++) {
                lauta[kohta++] = new Sotilas(aloitusX, i, vari, SOTILAS);
            }
        }
    }

    public void piirraLauta() {
        String[][] piirros = new String[8][8];
        for (int i = 0; i < piirros.length; i++) {
            String[] piirro = piirros[i];
            for (int j = 0; j < piirro.length; j++) {
                piirro[j] = "#";
            }
        }
        for (int i = 0; i < lauta.length; i++) {
            Nappula nappula = lauta[i];
            int x = nappula.getSijainti().getX();
            int y = nappula.getSijainti().getY();
            piirros[x][y] = nappula.piirra();
        }
        for (int i = 0; i < piirros.length; i++) {
            String[] piirro = piirros[i];
            for (int j = 0; j < piirro.length; j++) {
                System.out.print(piirro[j]);
            }
            System.out.println("");
        }
    }

    private void syo(int s) { //Kirjoitetaan tarvittaessa omalla
        Nappula[] uus = new Nappula[lauta.length-1];
        System.arraycopy(lauta, 0, uus, 0, s);
        System.arraycopy(lauta, s+1, uus, s, lauta.length - s - 1);
        this.lauta = uus;
        System.out.println("onnistuiko");
    }
}
