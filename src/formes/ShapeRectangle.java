package formes;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class ShapeRectangle implements Shapes{

    private final int gauche;
    private final int haut;
    private final int droite;
    private final double angle;
    private final int bas;
    private final Color color;
    public ShapeRectangle(int gauche, int haut, int droite, int bas, int angle, MyColor color) {
        this.color = color.toAwt();
        this.gauche = gauche;
        this.haut = haut;
        this.droite = droite;
        this.bas = bas;
        this.angle = angle;
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        AffineTransform old = g2d.getTransform(); // sauvegarde

        int cx = (droite + gauche) / 2;
        int cy = (haut + bas) / 2;

        int width = droite - gauche;
        int height = bas - haut;

        g2d.setColor(color);
        g2d.rotate(angle, cx, cy);
        g2d.drawRect(gauche, haut, width, height);

        g2d.setTransform(old); // restauration
    }
}
