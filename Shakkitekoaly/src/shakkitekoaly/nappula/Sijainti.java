
package shakkitekoaly.nappula;

/**
 *  Luokka pitää x ja y koordinaatteja pelilautaa ja sääntöjen ylläpitoa varten.
 */
public class Sijainti {

    private int x;
    private int y;

    /**
     * Konstruktori tarkistaa ettei yritetä tehdä sijaintia alueen ulkopuolelle ja
     * asettaa sitten x ja y koordinaatit.
     * @param x Positiivinen koordinaatti jossa sijainti on, pienempi kuin 8.
     * @param y Positiivinen koordinaatti jossa sijainti on, pienempi kuin 8.
     */
    public Sijainti(int x, int y) {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException("Yritettiin luoda sijaintia kentän ulkopuolelle");
        } else {
            this.x = x;
            this.y = y;
        }
    }

    /**
     * Palauttaa sijainnin X koodinaatin.
     * @return Koordinaatti kokonaislukuna.
     */
    public int getX() {
        return x;
    }

    /**
     * Tarkistaa ettei annettu luku ole alueen ulkopuolella ja sitten asettaa
     * x koordinaatin.
     * @param x Positiivinen koordinaatti jossa sijainti on, pienempi kuin 8.
     */
    public void setX(int x) {
        if (x < 0) {
            throw new IllegalArgumentException("Yritettiin asettaa sijaintia kentän ulkopuolelle");
        } else {
            this.x = x;
        }
    }

    /**
     * Palauttaa sijainnin Y koodinaatin.
     * @return Koordinaatti kokonaislukuna.
     */
    public int getY() {
        return y;
    }

    /**
     * Tarkistaa ettei annettu luku ole alueen ulkopuolella ja sitten asettaa
     * y koordinaatin.
     * @param y Positiivinen koordinaatti jossa sijainti on, pienempi kuin 8.
     */
    public void setY(int y) {
        if (y < 0) {
            throw new IllegalArgumentException("Yritettiin asettaa sijaintia kentän ulkopuolelle");
        } else {
            this.y = y;
        }
    }

    /**
     * Tarkistetaan onko sijainti sama kuin jollakin toisella.
     * @param o Verrattava sijainti.
     * @return Tosi jos sijainnin X ja Y koordinaatit vastaavat.
     */
    @Override
    public boolean equals(Object o) {
        if (o.getClass() != this.getClass()) {
            return false;
        }
        return o.hashCode() == this.hashCode();
    }

    /**
     * Sijainnin hashcode tehdään x ja y koordinaateista.
     * @return Palauttaa kokonaisluvun joka riippuu x ja y koordinaateista.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.x;
        hash = 71 * hash + this.y;
        return hash;
    }
}
