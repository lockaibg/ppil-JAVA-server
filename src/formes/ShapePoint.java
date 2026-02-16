package formes;

import java.awt.*;

/**
 * Objet représentant un point pour simplifier le code
 */
public class ShapePoint {
    private int x;
    private final int y;

    /**
     * Constructeur
     * @param x coordonnée x
     * @param y coordonnée y
     */
    public ShapePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * get du X
     * @return this.x
     */
    public int getX() {
        return x;
    }

    /**
     * get du Y
     * @return this.y
     */
    public int getY() {
        return y;
    }
}
