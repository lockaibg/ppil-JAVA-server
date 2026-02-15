package chainOfResponsability;

import request.Request;

/**
 * Classe abstraite contenant la definition de dessiner et dessiner1 ainsi que l'initialisation de dessin2
 */
public abstract class FormesCOR implements Formes {
    FormesCOR suivant;

    public FormesCOR(FormesCOR suivant) {
        this.suivant = suivant;
    }

    @Override
    public String dessiner(Request request) {
        String s = this.dessiner1(request);
        if(s != null) return s;
        else return "Mauvais maillon";
    }

    /**
     * parcours de la chaine de responsabilité
     * @param request
     * @return
     */
    public String dessiner1(Request request) {
        String s = dessiner2(request);
        if(s != null) return s;
        else {
            if(this.suivant == null) return null;
            else return this.suivant.dessiner1(request);
        }
    }

    /**
     * test de la capacité a résoudre le problème du maillon et résolution de celu-ci si possible
     * @param request
     * @return echec = null, succes = le type de forme créé
     */
    public abstract String dessiner2(Request request);
}
