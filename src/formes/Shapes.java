package formes;

import java.awt.*;

/**
 * Interface contenant les methodes utilisable par les formes (dessiner)
 */
public interface Shapes {
    /**
     * Permet de dessiner les formes enregistrées
     * @param g le canva de dessin utilisé
     */
    void draw(Graphics g);

    double getTop();
    double getLeft();
    double getBottom();
    double getRight();

    void refactor(double ordoX, double ordoY, double rapport);
}
