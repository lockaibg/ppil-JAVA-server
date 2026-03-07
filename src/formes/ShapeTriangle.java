package formes;

import java.awt.*;
import java.awt.geom.AffineTransform;

/**
 * Object représentant un triangle
 */
public class ShapeTriangle implements Shapes {
    private final ShapePoint a;
    private final ShapePoint b;
    private final ShapePoint c;
    private final Color color;

    /**
     * Constructeur
     * @param a un point
     * @param b un point
     * @param c un point
     * @param myColor une couleure parmis celles de MyColor
     */
    public ShapeTriangle(ShapePoint a, ShapePoint b, ShapePoint c, MyColor myColor) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.color = myColor.toAwt();
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(color);
        g2d.drawLine((int) a.getX(), (int) a.getY(), (int) b.getX(), (int) b.getY());
        g2d.drawLine((int) b.getX(), (int) b.getY(), (int) c.getX(), (int) c.getY());
        g2d.drawLine((int) c.getX(), (int) c.getY(), (int) a.getX(), (int) a.getY());

    }

    @Override
    public double getTop() {
        if (a.getY() > b.getY() && a.getY() > c.getY()) {
            return a.getY();
        } else if (b.getY() > a.getY() && b.getY() > c.getY()) {
            return b.getY();
        } else {
            return c.getY();
        }
    }

    @Override
    public double getLeft() {
        if (a.getX() < b.getX() && a.getX() < c.getX()) {
            return a.getX();
        } else if (b.getX() < a.getX() && b.getX() < c.getX()) {
            return b.getX();
        } else {
            return c.getX();
        }
    }

    @Override
    public double getBottom() {
        if (a.getY() < b.getY() && a.getY() < c.getY()) {
            return a.getY();
        } else if (b.getY() < a.getY() && b.getY() < c.getY()) {
            return b.getY();
        } else {
            return c.getY();
        }
    }

    @Override
    public double getRight() {
        if (a.getX() > b.getX() && a.getX() > c.getX()) {
            return a.getX();
        } else if (b.getX() > a.getX() && b.getX() > c.getX()) {
            return b.getX();
        } else {
            return c.getX();
        }
    }

    @Override
    public void refactor(double ordoX, double ordoY, double rapport) {
        this.a.setX((this.a.getX() - ordoX) * rapport);
        this.a.setY((this.a.getY() - ordoY) * rapport);
        this.b.setX((this.b.getX() - ordoX) * rapport);
        this.b.setY((this.b.getY() - ordoY) * rapport);
        this.c.setX((this.c.getX() - ordoX) * rapport);
        this.c.setY((this.c.getY() - ordoY) * rapport);
    }
}
