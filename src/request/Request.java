package request;
import formes.*;

import java.util.List;

public class Request {

    private final String type;
    private final List<Integer> params;
    private final MyColor color;
    private ShapeList list;


    public Request(String type, List<Integer> params, String color, ShapeList list) {
        this.type = type;
        this.params = params;
        this.color = MyColor.valueOf(color);
        this.list = list;
    }
    public String getType() {
        return type;
    }
    public List<Integer> getParams() {
        return params;
    }
    public MyColor getColor() {
        return color;
    }
    public ShapeList getList() {
        return list;
    }
    public void addList(Shapes shape) {
        this.list.addDraws(shape);
    }
}
