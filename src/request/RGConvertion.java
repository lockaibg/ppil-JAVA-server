package request;

import formes.MyColor;
import formes.ShapeList;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe permettant de passer de la chaine de charactere de requete à un objet requete
 */
public class RGConvertion {
    private final String stRequest;
    private Request rq;
    private final ShapeList shapeList;

    /**
     * Constructeur
     * @param stRequest la chaine de charactere de requete
     * @param shapeList la liste de formes a dessiner
     */
    public RGConvertion(String stRequest, ShapeList shapeList) {
        this.stRequest = stRequest;
        this.shapeList = shapeList;
        if(convertable())
            convert();
        else
            System.out.println("Erreur de regex");
    }

    /**
     * Vérifie si une chaine de charactere peut etre convertie en requete
     * @return true si c'est possible false sinon
     */
    public boolean convertable() {
        List<String> matchableString = new ArrayList<String>();
        matchableString.add("^@OVAL ([0-9]{1,3}(.[0-9]{1,3})? ){5}[A-Z]+$");
        matchableString.add("^@TRIANGLE ([0-9]{1,3}(.[0-9]{1,3})? ){6}[A-Z]+$");
        matchableString.add("^@SEGMENT ([0-9]{1,3}(.[0-9]{1,3})? ){4}[A-Z]+$");
        matchableString.add("^@RECTANGLE ([0-9]{1,3}(.[0-9]{1,3})? ){4}[A-Z]+$");
        matchableString.add("^@POLYGONE ([0-9]{1,3}(.[0-9]{1,3})? ){8,}[A-Z]+$");
        matchableString.add("^@DESSINER ([0-9]{1,3}(.[0-9]{1,3})? ){2}[A-Z]+$");
        for (String s : matchableString) {
            if(stRequest.matches(s)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Créer l'objet Request à partir du string de requête
     */
    public void convert() {
        String[] elems = stRequest.split(" ");
        String type = elems[0].substring(1);
        List<Double> params = new ArrayList<>();
        String myColor = "BLACK";
        for (String s : elems) {
            if(s.matches("^[0-9]{1,3}(,[0-9]{1,3})?$")) {
                params.add(Double.parseDouble(s));
            } else if(s.matches("[A-Z]*")) {
                myColor = s;
            }
        }
        this.rq = new Request(type, params, myColor, shapeList);
    }

    /**
     * get request
     * @return this.rq
     */
    public Request getRq() {
        return rq;
    }
}
