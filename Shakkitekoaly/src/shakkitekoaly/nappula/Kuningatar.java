/**
 * 
 */
package shakkitekoaly.nappula;

import static shakkitekoaly.nappula.Tyyppi.KUNINGATAR;

public class Kuningatar extends Nappula {

    public Kuningatar(Sijainti s, boolean vari) {
        super(s, vari, KUNINGATAR);
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
            return "Q";
        }
        return "q";    }
    
}
