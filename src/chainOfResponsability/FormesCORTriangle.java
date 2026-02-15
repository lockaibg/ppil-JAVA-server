package chainOfResponsability;

import formes.*;
import request.Request;

public class FormesCORTriangle extends FormesCOR {

    public FormesCORTriangle(FormesCOR suivant) {
        super(suivant);
    }

    @Override
    public String dessiner2(Request request) {
        String type = request.getType();
        if(!type.equalsIgnoreCase("TRIANGLE")) {
            return null;
        } else {
            ShapeTriangle sh = new ShapeTriangle(new ShapePoint(request.getParams().get(0), request.getParams().get(1)), new ShapePoint(request.getParams().get(2), request.getParams().get(3)), new ShapePoint(request.getParams().get(4), request.getParams().get(5)), request.getColor());
            request.addList(sh);
            return "TRIANGLE";
        }
    }
}
