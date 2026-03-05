package chainOfResponsability;

import request.Request;

/**
 * Interface contenant la méthode de base du COR
 */
public interface Formes {
    /**
     * méthode de base du COR
     * @param request L'object contenant la requete en cours de traitement
     * @return le type de forme créé
     */
    public String dessiner(Request request);
}
