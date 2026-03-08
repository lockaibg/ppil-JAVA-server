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

    /**
     * setter de x
     * @param x nouveau x
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * setter de y
     * @param y nouveau y
     */
    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "ShapePoint{" + "x=" + x + ", y=" + y + '}';
    }
}
