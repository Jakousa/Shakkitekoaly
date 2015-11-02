package shakkitekoaly.nappula;

import java.util.Objects;

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
    
    public void setSijainti(Sijainti s) {
        this.sijainti = s;
    }
    
    public boolean siirry(Sijainti lahto, Sijainti kohde){
        if (kohde.getX() > 7 || kohde.getX() < 0 ||
                kohde.getY() > 7 || kohde.getY() < 0 || 
                (lahto.getX() == kohde.getX() && lahto.getY() == kohde.getY())){
            return false;
        }
        if (okSiirtya(lahto, kohde)) {
            return true; //Lisätään muuta. Eipä lisätäkkään
        }
        return false;
    }
    
    public abstract boolean okSiirtya(Sijainti lahto, Sijainti kohde);
    
    public abstract String piirra();
    
    @Override
    public boolean equals(Object obj) {
        return obj.hashCode() == this.hashCode();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.sijainti);
        hash = 19 * hash + Objects.hashCode(this.tyyppi);
        hash = 19 * hash + (this.vari ? 1 : 0);
        return hash;
    }
}
