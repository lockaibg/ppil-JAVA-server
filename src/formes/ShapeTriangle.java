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
        g2d.drawLine(a.getX(), a.getY(), b.getX(), b.getY());
        g2d.drawLine(b.getX(), b.getY(), c.getX(), c.getY());
        g2d.drawLine(c.getX(), c.getY(), a.getX(), a.getY());

    }
}
