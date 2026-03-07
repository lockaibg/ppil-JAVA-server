package formes;

import java.awt.*;
import java.awt.geom.AffineTransform;

/**
 * Objet représentatn un rectangle
 */
public class ShapeRectangle implements Shapes{

    private double gauche;
    private double haut;
    private double droite;
    private final double angle;
    private double bas;
    private final Color color;

    /**
     * Constructeur
     * @param gauche la coordonnée x des points de gauche
     * @param haut la coordonnée y des points du haut
     * @param droite la coordonnée x des points de droite
     * @param bas la coordonnée y des points du bas
     * @param angle l'angle de rotation
     * @param color Une couleur parmi celle de MyColor
     */
    public ShapeRectangle(double gauche, double haut, double droite, double bas, double angle, MyColor color) {
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

        int cx = ((int) (droite + gauche)) / 2;
        int cy = ((int) (haut + bas)) / 2;

        int width = (int) (droite - gauche);
        int height = (int) (bas - haut);

        g2d.setColor(color);
        g2d.rotate(angle, cx, cy);
        g2d.drawRect((int) gauche, (int) haut, width, height);

        g2d.setTransform(old); // restauration
    }

    @Override
    public double getTop() {
        return haut;
    }

    @Override
    public double getLeft() {
        return gauche;
    }

    @Override
    public double getBottom() {
        return bas;
    }

    @Override
    public double getRight() {
        return droite;
    }

    @Override
    public void refactor(double ordoX, double ordoY, double rapport) {
        this.haut = size - ((this.haut - ordoY) * rapport) + add_top_left;
        this.gauche = ((gauche - ordoX) * rapport) + add_top_left;
        this.bas = size - ((bas - ordoY) * rapport) + add_top_left;
        this.droite = ((droite - ordoX) * rapport) + add_top_left;
        System.out.println(this.toString());
    }
    @Override
    public String toString() {
        return "RECTANGLE bas : " + this.bas + " haut : " + this.haut + " droite : " + this.droite + " gauche : " + this.gauche;
    }
}
