package request;
import formes.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Object représentant une requête du client
 */
public class Request {

    private final String type;
    //TODO pas sur que ça soit final ça faudrat vérifier avec les test
    private final List<Integer> params = new ArrayList<Integer>();
    private final MyColor color;
    private final ShapeList list;

    /**
     * Constructeur
     * @param type type de forme
     * @param params liste d'entiers donnés en parametres
     * @param color couleur demandée
     * @param list liste de formes liés a la requête
     */
    public Request(String type, List<Double> params, String color, ShapeList list) {
        this.type = type;
        this.color = MyColor.valueOf(color);
        this.list = list;
        double pixelSize = getPixelSize();
        for(Double d : params) {
            int nbPixel = (int) Math.round(d / pixelSize);
            this.params.add(nbPixel);
        }
    }

    /**
     * Fonction static permettant de trouver la taille d'un pixel sur un écran donné
     * @return taille d'un pixel en cm
     */
    public static double getPixelSize() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();

        int dpi = toolkit.getScreenResolution();

        return 2.54 / dpi;
    }

    /**
     * get du type de dessin
     * @return this.type
     */
    public String getType() {
        return type;
    }

    /**
     * get de la liste des parametres entiers
     * @return this.params
     */
    public List<Integer> getParams() {
        return params;
    }

    /**
     * get de la couleur
     * @return this.color
     */
    public MyColor getColor() {
        return color;
    }

    /**
     * get de la list de forme liée à la demande
     * @return this.list
     */
    public ShapeList getList() {
        return list;
    }

    /**
     * ajouter une forme à la list
     * @param shape la forme à ajouter
     */
    public void addList(Shapes shape) {
        this.list.addDraws(shape);
    }

    @Override
    public String toString() {
        String s = "type: " + type + "\n";
        s += "params: " + params + "\n";
        return s;
    }
}
