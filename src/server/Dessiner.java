package server;

import formes.*;
import request.Request;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Class permettant le dessin
 */
public class Dessiner extends Frame {

    private final ShapeList shapeList;
    private final Request rq;

    /**
     * Constructeur
     * @param rq la requete contenant les parametre de la fenetre
     */
    public Dessiner(Request rq) {
        this.rq = rq;
        this.shapeList = rq.getList();

        System.out.println(shapeList.toString());
        setTitle("Dessin");
        setSize(rq.getParams().get(0), rq.getParams().get(1));
        setBackground(rq.getColor().toAwt());
        setLayout(new FlowLayout());

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
        for(Shapes sh : shapeList.getdraws()) {
            sh.draw(g);
        }
    }
}
