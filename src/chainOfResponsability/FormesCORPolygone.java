package chainOfResponsability;

import formes.*;
import request.Request;

import java.util.ArrayList;
import java.util.List;

/**
 * Maillon s'occupant d'une demande de polygone
 */
public class FormesCORPolygone extends FormesCOR {

    /**
     * Constructeur hérité de FormesCOR
     * @param suivant = null si aucun maillon restant, un maillon différent du COR sinon
     */
    public FormesCORPolygone(FormesCOR suivant) {
        super(suivant);
    }

    @Override
    public String dessiner2(Request request) {
        String type = request.getType();
        if(!type.equalsIgnoreCase("POLYGONE")) {
            return null;
        } else {
            List<ShapePoint> points = new ArrayList<>();
            for(int i = 0; i < request.getParams().size(); i+=2) {
                points.add(new ShapePoint(request.getParams().get(i), request.getParams().get(i+1)));
            }
            ShapePolygone sh = new ShapePolygone(points, request.getColor());
            request.addList(sh);
            return "POLYGONE";
        }
    }
}
