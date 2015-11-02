package shakkitekoaly.nappula;

public class Sotilas extends Nappula {

    public Sotilas(int x, int y, boolean vari, Tyyppi tyyppi) {
        super(x, y, vari, tyyppi);
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
