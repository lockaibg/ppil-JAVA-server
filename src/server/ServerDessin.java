package server;

import formes.ShapeList;
import request.*;
import chainOfResponsability.*;

import java.awt.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * class liant les requete au dessin
 */
public class ServerDessin extends Frame {
    /**
     * initialisation des COR
     */
    private static final FormesCOROval oval = new FormesCOROval(null);
    private static final FormesCORPolygone polygone = new FormesCORPolygone(oval);
    private static final FormesCORSegment seg = new FormesCORSegment(polygone);
    private static final FormesCORSquare square = new FormesCORSquare(seg);
    private static final FormesCORTriangle tri = new FormesCORTriangle(square);

    /**
     * constructeur par défaut inutilisé car uniquement parametres statics
     */
    public ServerDessin() {}

    /**
     * Ecoute les connections avec le serveur et effectu les requetes lorsqu'elles arrivent
     * @param args osef
     */
    public static void main(String[] args) {
        int port = 9111;
        ShapeList shapeList = new ShapeList();
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Serveur Java en écoute sur le port " + port + "...");

            while (true) {
                Socket socketClient = serverSocket.accept();
                System.out.println("\nNouveau client C++ connecté");

                try (BufferedReader in = new BufferedReader(new InputStreamReader(socketClient.getInputStream()))) {
                    String requete;
                    while ((requete = in.readLine()) != null) {
                        System.out.println("Reçu du C++ : " + requete);

                        //génération du Request
                        RGConvertion convertion= new RGConvertion(requete, shapeList);
                        Request rq = convertion.getRq();

                        //si la requete est de type dessiner on appel la class de dessin
                        if(rq.getType().equals("DESSINER")) {
                            System.out.println("oui");
                            new Dessiner(rq);
                            shapeList = new ShapeList();
                        }
                        System.out.println(rq.toString());

                        String reponse = tri.dessiner(rq);
                    }
                } catch (Exception e) {
                    System.err.println("Erreur de lecture avec ce client : " + e.getMessage());
                }

                System.out.println("Client C++ déconnecté. En attente du prochain...");
            }
        } catch (Exception e) {
            System.err.println("Erreur fatale du serveur : " + e.getMessage());
        }
    }
}
