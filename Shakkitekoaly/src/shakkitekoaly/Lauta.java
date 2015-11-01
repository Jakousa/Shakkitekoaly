package shakkitekoaly;

import shakkitekoaly.nappula.*;
import static shakkitekoaly.nappula.Tyyppi.*;

/**
 *
 * @author hatchy
 */
public class Lauta {

    private Nappula[] lauta;

    public Lauta() {
        lauta = new Nappula[16 * 2];
        alustusApu(0, false);
        alustusApu(1, false);
        alustusApu(7, true);
        alustusApu(6, true);
    }

    private void alustusApu(int aloitusX, boolean vari) {
        int i = 0;
        if (aloitusX == 0 || aloitusX == 7) {
            lauta[i] = new Torni(aloitusX, i++, vari, TORNI);
            lauta[i] = new Ratsu(aloitusX, i++, vari, RATSU);
            lauta[i] = new Lahetti(aloitusX, i++, vari, LAHETTI);
            lauta[i] = new Kuningatar(aloitusX, i++, vari, KUNINGATAR);
            lauta[i] = new Kuningas(aloitusX, i++, vari, KUNINGAS);
            lauta[i] = new Lahetti(aloitusX, i++, vari, LAHETTI);
            lauta[i] = new Ratsu(aloitusX, i++, vari, RATSU);
            lauta[i] = new Torni(aloitusX, i++, vari, TORNI);
        } else {
            for (i = 0; i < lauta.length/4; i++) {
                lauta[i] = new Sotilas(aloitusX, i, vari, SOTILAS);
            }
        }
    }
}
