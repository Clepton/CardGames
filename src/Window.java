import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame {
    // Définition des dimensions de la fenêtre
    private static final int BOARD_WIDTH = 1000;
    private static final int BOARD_HEIGHT = 800;

    private JPanel gamePanel;
    private JPanel buttonPanel;
    private JButton playButton;
    private JLabel scoreLabel; // Étiquette pour afficher le score

    private Deck deck;
    private Hand hand;
    private Score score;

    // Chemin vers le dossier contenant les images des cartes
    private static final String CARD_IMAGES_PATH = "chemin_vers_le_dossier_des_images/";

    public Window() {
        // Appeler le constructeur de la classe parent JFrame avec le titre de la fenêtre
        super("Ma Fenêtre");

        // Création et configuration de la fenêtre
        setSize(BOARD_WIDTH, BOARD_HEIGHT);
        setLocationRelativeTo(null); // Centrer la fenêtre sur l'écran
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialisation des composants
        gamePanel = new JPanel();
        gamePanel.setLayout(new FlowLayout()); // Utiliser un layout de type FlowLayout pour afficher les cartes côte à côte
        gamePanel.setBackground(new Color(53, 101, 77));

        buttonPanel = new JPanel();
        playButton = new JButton("Play");

        // Ajout des boutons au panel de boutons
        buttonPanel.add(playButton);

        // Ajout de l'étiquette du score
        scoreLabel = new JLabel("Score: ");
        buttonPanel.add(scoreLabel);

        // Ajout du panel de jeu et du panel de boutons à la fenêtre
        add(gamePanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Création du deck de cartes, de la main et de l'objet Score
        deck = new Deck();
        hand = new Hand(deck);
        score = new Score(0);

        // Ajout d'un gestionnaire d'événements pour le bouton playButton
        playButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Affichage de la main de cartes dans la fenêtre
                displayHand(hand.getCards());

                // Mise à jour et affichage du score
                score.setScore(0); // Réinitialiser le score à chaque tour
                scoreLabel.setText("Score: " + score.getScore());

                // Actions pour le prochain tour de jeu
                hand.discardedCard(deck);
                hand.printHiddenCards(deck); // Afficher les cartes cachées
            }
        });

        // Afficher la fenêtre
        setVisible(true);
    }

    // Méthode pour afficher les cartes dans la main
    public void displayHand(ArrayList<Card> hand) {
        // Nettoyer le panel de jeu avant d'ajouter de nouveaux éléments
        gamePanel.removeAll();

        // Charger et afficher les images des cartes dans la main
        for (Card card : hand) {
            String imagePath = "Cards/" + card.getNumber() + card.getSuit() + ".png"; // Chemin vers le fichier image de la carte
            ImageIcon icon = new ImageIcon(imagePath); // Charger l'image de la carte depuis le fichier PNG
            JLabel cardLabel = new JLabel(icon); // Créer un JLabel avec l'icône de l'image
            gamePanel.add(cardLabel); // Ajouter le JLabel au panel de jeu
        }

        // Rafraîchir l'affichage de la fenêtre
        revalidate();
        repaint();
    }

}
