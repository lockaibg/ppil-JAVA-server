package formes;

import java.util.ArrayList;
import java.util.List;

/**
 * Liste des formes demandées dans la requête qu'il faut afficher
 */
public class ShapeList {
    private List<Shapes> draws = new ArrayList<Shapes>();

    /**
     * Constructeur par défaut car aucun besoin d'initialisation
     */
    public ShapeList() {}

    /**
     * get des formes
     * @return this.draws
     */
    public List<Shapes> getdraws() {
        return draws;
    }

    /**
     * ajouter une forme à la liste
     * @param draw forme à ajouter
     */
    public void addDraws(Shapes draw) {
        this.draws.add(draw);
    }

    @Override
    public String toString() {
        return "ShapeList [draws=" + draws.toString() + "]";
    }
}
