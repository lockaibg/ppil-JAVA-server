package formes;

import java.awt.*;

/**
 * Interface contenant les methodes utilisable par les formes (dessiner)
 */
public interface Shapes {
    /**
     * taille de la zone de dessin
     */
    public static final int size = 500;
    /**
     * comme la zone de dessin est plus petite que la fenetre on ajoute un padding
     */
    public static final int add_top_left = 30;
    /**
     * Permet de dessiner les formes enregistrées
     * @param g le canva de dessin utilisé
     */
    void draw(Graphics g);

    /**
     * calcule la borne supérieur de la boite contenant l'objet
     * @return coordY de la borne
     */
    double getTop();

    /**
     * calcule la borne de gauche de la boite contenant l'objet
     * @return coordX de la borne
     */
    double getLeft();

    /**
     * calcule la borne inférieur de la boite contenant l'objet
     * @return coordY de la borne
     */
    double getBottom();

    /**
     * calcule la borne de droite de la boite contenant l'objet
     * @return coordX de la borne
     */
    double getRight();

    /**
     * recalcule les coordonnées de la forme en fonction de la modification de plan
     * @param ordoX deplacement latéral a effectuer par rapport au plan
     * @param ordoY deplacement en hauteur a effectuer par rapport au plan
     * @param rapport homotétie a effectuer
     */
    void refactor(double ordoX, double ordoY, double rapport);
}
