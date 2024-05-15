import java.util.Scanner;
//test
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
            score.setScore(hand);
            System.out.println("Score: " + score.getScore());
            System.out.print("Continuer à jouer ? O/N : ");
            loop = scanner.nextLine();


            //version qui permetait de tester le programme avant d'avoir l'interface
            while (!loop.equalsIgnoreCase("O") && !loop.equalsIgnoreCase("N")) {
                System.out.println("Erreur : Veuillez entrer O ou N");
                loop = scanner.nextLine();
            }
            hand.discardedCard(deck);
        }
    }

    public void playButtonAction() {
        window.displayHand(hand.getCards());
        score.setScore(hand);
        hand.discardedCard(deck);
    }
}