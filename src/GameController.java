import java.util.Scanner;

public class GameController {
    private Window window;
    private Deck deck;
    private Hand hand;
    private Score score;
    private int jokerCount;

    public GameController() {
        window = new Window();
        deck = new Deck();
        hand = new Hand(deck);
        score = new Score();
        jokerCount = 3;
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        String loop = "O";

        while ("O".equalsIgnoreCase(loop)) {
            window.displayHand(hand.getCards());
            score.setScore();
            System.out.println("Score: " + score.getScore());
            System.out.print("Continuer à jouer ? O/N : ");
            loop = scanner.nextLine();
            while (!loop.equalsIgnoreCase("O") && !loop.equalsIgnoreCase("N")) {
                System.out.println("Erreur : Veuillez entrer O ou N");
                loop = scanner.nextLine();
            }
            hand.discardedCard(deck);
        }
    }

    public void playButtonAction() {
        window.displayHand(hand.getCards());
        score.setScore();
        hand.discardedCard(deck);
    }

    public void useJoker() {
        if (jokerCount > 0) {
            jokerCount--;
        } else {
            System.out.println("Vous avez utilisé tous les jokers disponibles.");
        }
    }
}
