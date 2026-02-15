package formes;

import java.util.ArrayList;
import java.util.List;

public class ShapeList {
    private List<Shapes> draws = new ArrayList<Shapes>();

    public List<Shapes> getdraws() {
        return draws;
    }
    public void addDraws(Shapes draw) {
        this.draws.add(draw);
    }
}
