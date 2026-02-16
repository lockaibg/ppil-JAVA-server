package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * thread
 */
public class Interlocuteur extends Thread {
    PrintStream fluxSortant;
    BufferedReader fluxEntrant;
    int noConnections;

    /**
     * constructeur
     * @param socket le socket utilisé
     * @param noConnections numéro de connextion
     * @throws IOException exception
     */
    public Interlocuteur(Socket socket, int noConnections) throws IOException {
        this.fluxSortant = new PrintStream(socket.getOutputStream());
        this.fluxEntrant = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.noConnections = noConnections;
    }

    /**
     * écoute les connexions entrantes
     */
    public void run() {
        try {
            System.out.println("Interlocuteur n°" + noConnections + " pret");
            while(!this.isInterrupted()) {
                String requete = this.fluxEntrant.readLine();
                System.out.println("le client n°" + this.noConnections + " a envoyé : " + requete);
                String reponse = "Requete reçu";
                this.fluxSortant.println(reponse);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
