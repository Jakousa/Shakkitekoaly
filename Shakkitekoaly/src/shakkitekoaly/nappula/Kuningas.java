/**
 * 
 */
package shakkitekoaly.nappula;

import static shakkitekoaly.nappula.Tyyppi.KUNINGAS;

public class Kuningas extends Nappula {

    public Kuningas(int x, int y, boolean vari) {
        super(x, y, vari, KUNINGAS);
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
