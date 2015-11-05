/**
 * 
 */
package shakkitekoaly.nappula;

import static shakkitekoaly.nappula.Tyyppi.TORNI;

public class Torni extends Nappula {

    public Torni(int x, int y, boolean vari) {
        super(x, y, vari, TORNI);
    }

    @Override
    public boolean okSiirtya(Sijainti lahto, Sijainti kohde) {
        return (kohde.getX() == lahto.getX() || kohde.getY() == lahto.getY());
    }

    @Override
    public String piirra() {
        if (this.getVari()) {
            return "T";
        }
            return "t";
        
    }
    
}
