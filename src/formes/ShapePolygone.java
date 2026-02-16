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
}
