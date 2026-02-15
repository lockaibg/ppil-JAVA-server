import formes.*;

import java.util.ArrayList;
import java.util.List;
import java.awt.*;
import java.awt.event.*;

public class Main extends Frame {

    private List<Shapes> shapeList = new ArrayList<Shapes>();

    public Main() {
        setTitle("Mon projet AWT");
        setSize(400, 300);
        setLayout(new FlowLayout());

        shapeList.add(new ShapeRectangle(20, 50, 30, 100, 0, MyColor.BLACK));
        shapeList.add(new ShapeRectangle(50, 50, 100, 70, 24, MyColor.YELLOW));
        shapeList.add(new ShapeOval(new ShapePoint(120, 40), 20,30, 13, MyColor.BLUE));
        shapeList.add(new ShapeSegment(new ShapePoint(200, 20), new ShapePoint(200, 150), MyColor.RED));
        shapeList.add(new ShapeTriangle(new ShapePoint(20, 40), new ShapePoint(86, 286), new ShapePoint(200, 40), MyColor.CYAN));

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
            }
        });

        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        for(Shapes sh : shapeList) {
            sh.draw(g);
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}
