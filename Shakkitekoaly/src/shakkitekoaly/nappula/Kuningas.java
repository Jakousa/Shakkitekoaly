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
public class Kuningas extends Nappula {

    public Kuningas(int x, int y, boolean vari, Tyyppi tyyppi) {
        super(x, y, vari, tyyppi);
    }

    @Override
    public boolean okSiirtya(Sijainti lahto, Sijainti kohde) {
        return (Math.abs(lahto.getX() - kohde.getX()) < 2 && 
                Math.abs(lahto.getY() - kohde.getY()) < 2);
    }

    @Override
    public String piirra() {
        if (this.getVari()) {
            return "K";
        }
        return "k";    }
    
}
