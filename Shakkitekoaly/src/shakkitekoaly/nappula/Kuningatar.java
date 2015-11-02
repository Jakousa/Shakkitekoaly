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
public class Kuningatar extends Nappula {

    public Kuningatar(int x, int y, boolean vari, Tyyppi tyyppi) {
        super(x, y, vari, tyyppi);
    }

    @Override
    public boolean okSiirtya(Sijainti lahto, Sijainti kohde) {
        return ((Math.abs(lahto.getX() - kohde.getX()) == 
                Math.abs(lahto.getY() - kohde.getY())) && 
                (kohde.getX() == lahto.getX() || kohde.getY() == lahto.getY()));
    }

    @Override
    public String piirra() {
        if (this.getVari()) {
            return "K";
        }
        return "k";    }
    
}
