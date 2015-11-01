package shakkitekoaly.nappula;

/**
 *
 * @author hatchy
 */
public abstract class Nappula {
    private Sijainti sijainti;
    private Tyyppi tyyppi;
    private boolean vari;
    
    public Nappula(int x, int y, boolean vari, Tyyppi tyyppi) {
        this.sijainti = new Sijainti(x, y);
        this.vari = vari;
        this.tyyppi = tyyppi;
    }
    
    public Tyyppi getTyyppi() {
        return tyyppi;
    }
    
    public boolean getVari() {
        return vari;
    }

    public Sijainti getSijainti() {
        return sijainti;
    }
    
    public abstract boolean siirry(Sijainti lahto, Sijainti kohde);
    
    public abstract String piirra();
}
