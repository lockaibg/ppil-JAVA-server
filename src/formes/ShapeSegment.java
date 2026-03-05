package formes;

import java.awt.*;

/**
 * Object représentant un segment
 */
public class ShapeSegment implements Shapes {
    private final ShapePoint start, end;
    private final Color color;

    /**
     * Constructeur
     * @param start un point
     * @param end un point
     * @param color Une couleur parmi celle de MyColor
     */
    public ShapeSegment(ShapePoint start, ShapePoint end, MyColor color) {
        this.color = color.toAwt();
        this.start = start;
        this.end = end;
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(color);
        g2d.drawLine(start.getX(), start.getY(), end.getX(), end.getY());
    }
}
