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
    public boolean siirry(Sijainti lahto, Sijainti kohde) {
        if (kohde.getX() < 0 || kohde.getX() > 8 || 
                kohde.getY() < 0 || kohde.getY() > 8) {
            return false;
        }
        if (kohde.getX() == lahto.getX() || kohde.getY() == lahto.getY()) {
            return true;
        }
        return false;
    }

    @Override
    public String piirra() {
        if (this.getVari()) {
            return "T";
        } else {
            return "t";
        }
    }
    
}
