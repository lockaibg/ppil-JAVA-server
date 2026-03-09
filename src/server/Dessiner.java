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
    private int size = 560;
    private final ShapeList shapeList;
    private final Request rq;

    /**
     * Constructeur
     * @param rq la requete contenant les parametre de la fenetre
     */
    public Dessiner(Request rq) {
        this.rq = rq;
        this.shapeList = rq.getList();

        setTitle("Dessin");
        setSize(size, size);
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
        double left = shapeList.getdraws().get(0).getLeft();
        double right = shapeList.getdraws().get(0).getRight();
        double bottom = shapeList.getdraws().get(0).getBottom();
        double top = shapeList.getdraws().get(0).getTop();
        //déterminer les coordonnées relatives du plan
        for (Shapes sh : shapeList.getdraws()) {
            if(sh.getLeft() < left) {
                left = sh.getLeft();
            }
            if(sh.getRight() > right) {
                right = sh.getRight();
            }
            if(sh.getBottom() < bottom) {
                bottom = sh.getBottom();
            }
            if(sh.getTop() > top) {
                top = sh.getTop();
            }
            //
        }

        double lenght;

        if(top - bottom > right - left ) {
            lenght = top - bottom;
        } else {
            lenght = right - left;
        }

        double facteur = 500 / lenght;
        System.out.println("ordox: " + left + " ordoy: " + bottom + " facteur: " + facteur);
        for (Shapes sh : shapeList.getdraws()) {
            sh.refactor(left, bottom, facteur);
        }

        for (Shapes sh : shapeList.getdraws()) {
            sh.draw(g);
        }
    }
}
