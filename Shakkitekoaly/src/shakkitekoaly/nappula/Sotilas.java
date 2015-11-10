/**
 * 
 */
package shakkitekoaly.nappula;

import static shakkitekoaly.nappula.Tyyppi.SOTILAS;

public class Sotilas extends Nappula {

    public Sotilas(Sijainti s, boolean vari) {
        super(s, vari, SOTILAS);
    }

    @Override
    public boolean okSiirtya(Sijainti lahto, Sijainti kohde) {
        int i = 1;
        if (this.getVari()) {
            i = -1;
        }
        return (Math.abs(lahto.getY() - kohde.getY()) < 2 && 
                lahto.getX() + i == kohde.getX());
    }

    @Override
    public String piirra() {
        if (this.getVari()) {
            return "S";
        }
        return "s";    }
    
}
