import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class TestEnregistrer {

    public static void main(String[] args) {
        try {
            int width = 400;
            int height = 300;

            // Création de l'image
            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

            // Récupération du contexte graphique
            Graphics2D g = image.createGraphics();

            // Dessin
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, width, height);

            g.setColor(Color.BLUE);
            g.fillOval(100, 50, 200, 150);

            g.dispose(); // Important

            // Sauvegarde
            File file = new File("mon_image.png");
            ImageIO.write(image, "png", file);

            System.out.println("Image sauvegardée !");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
