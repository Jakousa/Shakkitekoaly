package shakkitekoaly.nappula;

/**
 *
 * @author hatchy
 */
public class Torni extends Nappula {

    public Torni(int x, int y, boolean vari, Tyyppi tyyppi) {
        super(x, y, vari, tyyppi);
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
