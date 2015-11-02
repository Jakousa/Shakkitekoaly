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
public class Ratsu extends Nappula {

    public Ratsu(int x, int y, boolean vari, Tyyppi tyyppi) {
        super(x, y, vari, tyyppi);
    }

    @Override
    public boolean okSiirtya(Sijainti lahto, Sijainti kohde) {
        int x1 = lahto.getX();
        int x2 = kohde.getX();
        int y1 = lahto.getY();
        int y2 = kohde.getY();
        return (Math.abs(x1 - x2) == 2 && Math.abs(y1 - y2) == 1)
                || (Math.abs(x1 - x2) == 1 && Math.abs(y1 - y2) == 2);
    }

    @Override
    public String piirra() {
        if (this.getVari()) {
            return "R";
        }
        return "r";

    }

}
