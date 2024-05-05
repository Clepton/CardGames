import javax.swing.*;
import java.awt.*;
import javax.swing.ImageIcon;

public class Window extends JFrame {

    public Window() {
        // Appeler le constructeur de la classe parent JFrame avec le titre de la fenêtre
        super("Ma Fenêtre");

        // Création d'un panel pour la main de cartes en haut au centre
        JPanel topCenterPanel = new JPanel(new GridLayout(1, 4));
        // Ajout de différentes cartes à partir de différentes images
        String[] cardImages = {"Cards/10D.png", "Cards/10C.png", "Cards/10H.png", "Cards/10S.png"}; // Remplacez avec le chemin de vos images
        for (String imagePath : cardImages) {
            JLabel cardLabel = new JLabel();
            cardLabel.setIcon(new ImageIcon(imagePath));
            topCenterPanel.add(cardLabel);
        }

        // Création d'un panel pour la main de cartes en bas à gauche
        JPanel bottomLeftPanel = new JPanel(new GridLayout(1, 1));
        JLabel bottomLeftLabel = new JLabel();
        bottomLeftLabel.setIcon(new ImageIcon("image5.jpg")); // Remplacez avec le chemin de votre image
        bottomLeftPanel.add(bottomLeftLabel);

        // Création d'un panel principal pour la fenêtre
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(topCenterPanel, BorderLayout.CENTER);
        mainPanel.add(bottomLeftPanel, BorderLayout.SOUTH);

        // Ajout du panel principal à la fenêtre
        add(mainPanel);

        // Définition de la taille de la fenêtre
        setSize(400, 300);

        // Définition du comportement de fermeture de la fenêtre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Centrer la fenêtre sur l'écran
        setLocationRelativeTo(null);

        // Rendre la fenêtre visible
        setVisible(true);
    }
}