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
        g2d.drawLine((int) start.getX(), (int) start.getY(), (int) end.getX(), (int) end.getY());
    }

    @Override
    public double getTop() {
        if(start.getY() > end.getY()) {
            return start.getY();
        } else {
            return end.getY();
        }
    }

    @Override
    public double getLeft() {
        if (start.getX() < end.getX()) {
            return start.getX();
        } else {
            return end.getX();
        }
    }

    @Override
    public double getBottom() {
        if(start.getY() < end.getY()) {
            return start.getY();
        } else {
            return end.getY();
        }
    }

    @Override
    public double getRight() {
        if(start.getX() > end.getX()) {
        return start.getX();
        } else {
            return end.getX();
        }
    }

    @Override
    public void refactor(double ordoX, double ordoY, double rapport) {
        start.setX(start.getX() - ordoX * rapport);
        end.setX(end.getX() - ordoX * rapport);
        start.setY(start.getY() - ordoY * rapport);
        end.setY(end.getY() - ordoY * rapport);
    }
}
