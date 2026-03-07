package formes;

import java.util.ArrayList;
import java.util.List;
import java.awt.*;

/**
 * Objet représentant un polygone quelconque
 */
public class ShapePolygone implements Shapes{
    private final List<ShapePoint> points = new ArrayList<>();
    private final List<ShapeSegment> segments = new ArrayList<>();
    private final Color color;

    /**
     * Constructeur créant dinamiquement les segments à partir de la liste de points
     * @param points Les sommets de la forme
     * @param myColor Une couleur parmi celle de MyColor
     */
    public ShapePolygone(List<ShapePoint> points, MyColor myColor) {
        this.color = myColor.toAwt();
        this.points.addAll(points);
        for(int i = 0; i < points.size(); i++){
            ShapePoint p1 = points.get(i);
            ShapePoint p2 = points.get(i+1);
            if(p2 != null) {
                segments.add(new ShapeSegment(p1, p2, myColor));
            } else {
                segments.add(new ShapeSegment(p1, points.get(0), myColor));
            }
        }
    }

    @Override
    public void draw(Graphics g) {
        for(ShapeSegment seg : segments){
            seg.draw(g);
        }
    }

    @Override
    public double getTop() {
        double highest = points.get(0).getY();
        for(ShapePoint p : points){
            if(p.getY() > highest){
                highest = p.getX();
            }
        }
        return highest;
    }

    @Override
    public double getLeft() {
        double left = points.get(0).getX();
        for(ShapePoint p : points){
            if(p.getX() < left){
                left = p.getX();
            }
        }
        return left;
    }

    @Override
    public double getBottom() {
        double bottom = points.get(0).getY();
        for(ShapePoint p : points){
            if(p.getY() < bottom){
                bottom = p.getY();
            }
        }
        return bottom;
    }

    @Override
    public double getRight() {
        double right = points.get(0).getX();
        for(ShapePoint p : points){
            if(p.getX() > right){
                right = p.getX();
            }
        }
        return right;
    }

    @Override
    public void refactor(double ordoX, double ordoY, double rapport) {
        for(ShapePoint p : points){
            p.setX((p.getX() - ordoX) * rapport);
            p.setY((p.getY() - ordoY) * rapport);
        }
    }
}
