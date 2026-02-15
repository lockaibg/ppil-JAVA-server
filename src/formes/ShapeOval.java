package formes;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class ShapeOval implements Shapes {
    private final ShapePoint centre;
    private final int radiusHeight;
    private final int radiusWidth;
    private final double angle;
    private final Color color;

    public ShapeOval(ShapePoint centre, int radiusWidth, int radiusHeight, int angle, MyColor myColor) {
        this.color = myColor.toAwt();
        this.centre = centre;
        this.radiusWidth = radiusWidth;
        this.radiusHeight = radiusHeight;
        this.angle = Math.toRadians(angle);
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        AffineTransform old = g2d.getTransform();

        g2d.setColor(color);
        g2d.rotate(angle, centre.getX(), centre.getY());
        g2d.drawOval(centre.getX(), centre.getY(), radiusWidth, radiusHeight);

        g2d.setTransform(old);

    }
}
