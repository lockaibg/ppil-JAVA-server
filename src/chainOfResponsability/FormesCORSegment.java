package chainOfResponsability;

import formes.*;
import request.Request;

/**
 * Maillon s'occupant d'une demande de segment
 */
public class FormesCORSegment extends FormesCOR {

    /**
     * Constructeur hérité de FormesCOR
     * @param suivant = null si aucun maillon restant, un maillon différent du COR sinon
     */
    public FormesCORSegment(FormesCOR suivant) {
        super(suivant);
    }

    @Override
    public String dessiner2(Request request) {
        String type = request.getType();
        if(!type.equalsIgnoreCase("SEGMENT")) {
            return null;
        } else {
            ShapeSegment sh = new ShapeSegment(new ShapePoint(request.getParams().get(0), request.getParams().get(1)), new ShapePoint(request.getParams().get(2), request.getParams().get(3)), request.getColor());
            request.addList(sh);
            return "SEGMENT";
        }
    }
}
