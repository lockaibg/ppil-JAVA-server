package formes;

import java.awt.*;
import java.awt.geom.AffineTransform;

/**
 * objet représentant un oval (ou un rond si height = width)
 */
public class ShapeOval implements Shapes {
    private ShapePoint centre;
    private double radiusHeight;
    private double radiusWidth;
    private final double angle;
    private final Color color;

    /**
     * Constructeur
     * @param centre point central
     * @param radiusWidth longueur entre le centre et le côté de la forme
     * @param radiusHeight longueur entre le centre et la hauteure de la forme
     * @param angle angle de rotation
     * @param myColor Une couleur parmi celle de MyColor
     */
    public ShapeOval(ShapePoint centre, double radiusWidth, double radiusHeight, double angle, MyColor myColor) {
        this.color = myColor.toAwt();
        this.centre = centre;
        this.radiusWidth = radiusWidth;
        this.radiusHeight = radiusHeight;
        this.angle = angle;
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        AffineTransform old = g2d.getTransform();

        g2d.setColor(color);
        g2d.rotate(angle, centre.getX(), centre.getY());
        g2d.drawOval(
                (int) (centre.getX() - radiusWidth),
                (int) (centre.getY() - radiusHeight),
                (int) (2 * radiusWidth),
                (int) (2 * radiusHeight)
        );
        g2d.setTransform(old);
        System.out.println("x : " +this.centre.getX() + " y : " + this.centre.getY() + " width " + this.radiusWidth + " height " + this.radiusHeight);
    }

    /**
     * calcule la demi-largeur de la boite après rotation
     * @return Demi-largeur
     */
    private double getRotatedHalfWidth() {
        double cos = Math.cos(angle);
        double sin = Math.sin(angle);
        return Math.sqrt(radiusWidth * radiusWidth * cos * cos
                + radiusHeight * radiusHeight * sin * sin);
    }

    /**
     * calcule la demi-hauteur de la boite après rotation
     * @return Demi-hauteur
     */
    private double getRotatedHalfHeight() {
        double cos = Math.cos(angle);
        double sin = Math.sin(angle);
        return Math.sqrt(radiusWidth * radiusWidth * sin * sin
                + radiusHeight * radiusHeight * cos * cos);
    }

    @Override
    public double getTop() {
        return centre.getY() + getRotatedHalfHeight();
    }

    @Override
    public double getLeft() {
        return centre.getX() - getRotatedHalfWidth();
    }

    @Override
    public double getBottom() {
        return centre.getY() - getRotatedHalfHeight();
    }

    @Override
    public double getRight() {
        return centre.getX() + getRotatedHalfWidth();
    }

    @Override
    public void refactor(double ordoX, double ordoY, double rapport) {
        this.centre.setX(((this.centre.getX() - ordoX) * rapport) + add_top_left);
        double y = (this.centre.getY() - ordoY) * rapport;
        this.centre.setY(this.size - y + add_top_left);
        this.radiusHeight = this.radiusHeight * rapport;
        this.radiusWidth = this.radiusWidth * rapport;
        System.out.println(this.toString());
    }
    @Override
    public String toString() {
        return "OVAL x : " + this.centre.getX() + " y : " + this.centre.getY() + " width " + this.radiusWidth +  " height " + this.radiusHeight;
    }
}
