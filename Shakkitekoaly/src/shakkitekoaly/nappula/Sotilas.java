/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shakkitekoaly.nappula;

/**
 *
 * @author hatchy
 */
public class Sotilas extends Nappula {

    public Sotilas(int x, int y, boolean vari, Tyyppi tyyppi) {
        super(x, y, vari, tyyppi);
    }

    @Override
    public boolean okSiirtya(Sijainti lahto, Sijainti kohde) {
        return false; //Sotilaat vaativat enemmän työtä
    }

    @Override
    public String piirra() {
        if (this.getVari()) {
            return "S";
        }
        return "s";    }
    
}
