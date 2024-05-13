import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Création de la fenêtre de jeu
        Window window = new Window();

        // Lancer la boucle principale
        int s = 0;
        String loop = "O";

        // Création du deck de cartes
        Deck deck = new Deck();

        // Création de la main de cartes à partir du deck
        Hand hand = new Hand(deck);

        // Création d'un objet Score
        Score score = new Score(s);

        while ("O".equalsIgnoreCase(loop)) {
            // Affichage de la main de cartes dans la fenêtre
            window.displayHand(hand.getCards());

            // Mise à jour et affichage du score
            score.setScore(s);
            System.out.println(score.getScore());

            // Demande à l'utilisateur s'il veut continuer à jouer
            Scanner scanner = new Scanner(System.in);
            System.out.print("Continuer à jouer ? O/N : ");
            loop = scanner.nextLine();

            // Vérification de la réponse de l'utilisateur
            while (!loop.equalsIgnoreCase("O") && !loop.equalsIgnoreCase("N")) {
                System.out.println("Erreur : Veuillez entrer O ou N");
                loop = scanner.nextLine();
            }

            // Actions pour le prochain tour de jeu
            hand.discardedCard(deck);
            hand.printHiddenCards(deck); // Afficher les cartes cachées
        }
    }
}
