import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame {
    //test
    // Définition des dimensions de la fenêtre
    private static final int BOARD_WIDTH = 1000;
    private static final int BOARD_HEIGHT = 800;

    private JPanel gamePanel;
    private JPanel buttonPanel;
    private JButton playButton;
    private JButton jokerButton;
    private JButton replayButton; // Ajout du bouton replay

    private JLabel scoreLabel; // Étiquette pour afficher le score
    private JLabel jokerLabel; // Étiquette pour afficher le score

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
        jokerButton = new JButton("Joker");
        replayButton = new JButton("Replay"); // Ajout du bouton replay

        // Création du deck de cartes, de la main et de l'objet Score
        deck = new Deck();
        hand = new Hand(deck);
        score = new Score();

        // Ajout des boutons au panel de boutons
        buttonPanel.add(playButton);
        buttonPanel.add(jokerButton);
        buttonPanel.add(replayButton); // Ajout du bouton replay

        // Ajout de l'étiquette du score et joker restant
        jokerLabel = new JLabel("Joker restant : " + score.getJoker());
        buttonPanel.add(jokerLabel);
        scoreLabel = new JLabel("Score : " + score.getScore());
        buttonPanel.add(scoreLabel);

        // Ajout du panel de jeu et du panel de boutons à la fenêtre
        add(gamePanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Création du JLabel pour afficher les règles du jeu
        JLabel rulesLabel = new JLabel("Insérez les règles du jeu ici");
        gamePanel.add(rulesLabel); // Ajout du JLabel au panel de jeu

        // Ajout d'un gestionnaire d'événements pour le bouton playButton
        playButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Affichage de la main de cartes dans la fenêtre
                displayHand(hand.getCards());

                // Mise à jour et affichage du score
                score.setScore(hand); // Réinitialiser le score à chaque tour
                scoreLabel.setText("Score : " + score.getScore());

                // Actions pour le prochain tour de jeu
                hand.discardedCard(deck);
                hand.printHiddenCards(deck); // Afficher les cartes cachées
            }
        });

        // Ajout d'un gestionnaire d'événements pour le bouton jokerButton
        jokerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Vérifier si le nombre de jokers restants est supérieur à zéro
                if (score.getJoker() > 0) {
                    // Affichage de la main de cartes dans la fenêtre
                    displayHand(hand.getCards());

                    // Actions pour le prochain tour de jeu
                    hand.ApplyJoker(deck);
                    hand.printHiddenCards(deck); // Afficher les cartes cachées

                    score.setJoker();
                    // Mettre à jour l'étiquette affichant le nombre de jokers restants
                    jokerLabel.setText("Joker restant : " + score.getJoker());

                    // Ne pas mettre à jour le score lorsque le bouton Joker est cliqué
                } else {
                    // Afficher un message indiquant que le nombre maximal d'utilisations du joker est atteint
                    JOptionPane.showMessageDialog(null, "Vous avez utilisé tous les jokers disponibles.", "Limite atteinte", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        // Ajout d'un gestionnaire d'événements pour le bouton replayButton
        replayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Réinitialisation du jeu
                deck = new Deck(); // Créez un nouveau deck
                hand = new Hand(deck); // Créez une nouvelle main
                score = new Score(); // Réinitialisez le score

                // Mettez à jour l'interface utilisateur
                displayHand(hand.getCards()); // Affichez la nouvelle main
                scoreLabel.setText("Score : " + score.getScore()); // Réinitialisez l'affichage du score
                jokerLabel.setText("Joker restant : " + score.getJoker()); // Réinitialisez l'affichage des jokers restants
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