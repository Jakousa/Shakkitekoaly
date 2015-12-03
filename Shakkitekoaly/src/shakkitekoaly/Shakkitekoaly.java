package shakkitekoaly;

import shakkitekoaly.Shakki.Shakkipeli;

/**
 * Shakkitekoaly luokka aloittaa uuden Shakkipelin.
 *
 */
public class Shakkitekoaly {

    /**
     * Main käynnistää pelin.
     *
     * @param args
     */
    public static void main(String[] args) {
        Shakkipeli p = new Shakkipeli();
        p.pelaa();
    }
}
