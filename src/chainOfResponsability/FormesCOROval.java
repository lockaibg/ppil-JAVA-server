package chainOfResponsability;

import formes.ShapeOval;
import formes.ShapePoint;
import formes.ShapeRectangle;
import request.Request;

/**
 * Classe gérant une demande de forme Oval
 */
public class FormesCOROval extends FormesCOR {

    /**
     * super du constucteur de FormesCOR
     * @param suivant = null si aucun maillon restant, un maillon différent du COR sinon
     */
    public FormesCOROval(FormesCOR suivant) {
        super(suivant);
    }

    @Override
    public String dessiner2(Request request) {
        String type = request.getType();
        if(!type.equalsIgnoreCase("OVAL")) {
            return null;
        } else {
            ShapeOval sh = new ShapeOval(new ShapePoint(request.getParams().get(0), request.getParams().get(1)), request.getParams().get(2), request.getParams().get(3), request.getParams().get(4), request.getColor());
            request.addList(sh);
            return "OVAL";
        }
    }
}
