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
        g2d.drawOval((int) centre.getX(), (int) centre.getY(), (int) radiusWidth, (int) radiusHeight);

        g2d.setTransform(old);

    }

    @Override
    public double getTop() {
        return centre.getY() +  radiusHeight;
    }

    @Override
    public double getLeft() {
        return centre.getX() -  radiusWidth;
    }

    @Override
    public double getBottom() {
        return  centre.getY() -  radiusHeight;
    }

    @Override
    public double getRight() {
        return centre.getX() + radiusWidth;
    }

    @Override
    public void refactor(double ordoX, double ordoY, double rapport) {
        this.centre.setX((this.centre.getX() - ordoX) * rapport);
        this.centre.setY((this.centre.getY() - ordoY) * rapport);
        this.radiusHeight = this.radiusHeight * rapport;
        this.radiusWidth = this.radiusWidth * rapport;
    }
}
