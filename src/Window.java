import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    // Définition des dimensions de la fenêtre
    private static final int BOARD_WIDTH = 800;
    private static final int BOARD_HEIGHT = 600;

    private JPanel gamePanel;
    private JPanel buttonPanel;
    private JButton playButton;

    public Window() {
        // Appeler le constructeur de la classe parent JFrame avec le titre de la fenêtre
        super("Ma Fenêtre");

        // Création et configuration de la fenêtre
        setSize(BOARD_WIDTH, BOARD_HEIGHT);
        setLocationRelativeTo(null); // Centrer la fenêtre sur l'écran
        setResizable(false); // Empêcher le redimensionnement de la fenêtre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialisation des composants
        gamePanel = new JPanel();
        gamePanel.setLayout(new BorderLayout());
        gamePanel.setBackground(new Color(53, 101, 77));

        buttonPanel = new JPanel();
        playButton = new JButton("Play");

        // Ajout des boutons au panel de boutons
        buttonPanel.add(playButton);

        // Ajout du panel de jeu et du panel de boutons à la fenêtre
        add(gamePanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Afficher la fenêtre
        setVisible(true);
    }

    public static void main(String[] args) {
        // Création d'une instance de la classe Window pour afficher la fenêtre
        SwingUtilities.invokeLater(Window::new);
    }
}
