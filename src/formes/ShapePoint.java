package formes;

import java.awt.*;

/**
 * Objet représentant un point pour simplifier le code
 */
public class ShapePoint {
    private double x;
    private double y;

    /**
     * Constructeur
     * @param x coordonnée x
     * @param y coordonnée y
     */
    public ShapePoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * get du X
     * @return this.x
     */
    public double getX() {
        return x;
    }

    /**
     * get du Y
     * @return this.y
     */
    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {}
}
