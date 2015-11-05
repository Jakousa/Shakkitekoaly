/**
 * 
 */
package shakkitekoaly.nappula;

public class Sijainti {
    private int x;
    private int y;
    
    public Sijainti(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    @Override
    public boolean equals(Object o){
        if (o.getClass() != this.getClass()) {
            return false;
        }
        return o.hashCode() == this.hashCode();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.x;
        hash = 71 * hash + this.y;
        return hash;
    }
}
