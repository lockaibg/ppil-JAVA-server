package chainOfResponsability;
import formes.*;
import request.Request;

public class FormesCORSquare extends FormesCOR {

    public FormesCORSquare(FormesCOR suivant) {
        super(suivant);
    }

    @Override
    public String dessiner2(Request request) {
        String type = request.getType();
        if(!type.equalsIgnoreCase("RECTANGLE")) {
            return null;
        } else {
            ShapeRectangle sh = new ShapeRectangle(request.getParams().get(0), request.getParams().get(1), request.getParams().get(2), request.getParams().get(3), request.getParams().get(4), request.getColor());
            request.addList(sh);
            return "RECTANGLE";
        }
    }
}
