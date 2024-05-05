import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int s = 0;
        String loop = "O";

        Deck deck = new Deck(); // Create a deck of cards
        Hand hand = new Hand(deck); // Create a hand of cards from the deck
        Score score = new Score(s);

        while ("O".equalsIgnoreCase(loop)) {
            // Display the hand of cards
            hand.displayHand();

            // Update and display the score
            score.setScore(s);
            System.out.println(score.getScore());

            // Ask the user if they want to continue playing
            Scanner scanner = new Scanner(System.in);
            System.out.print("Continue playing? O/N : ");
            loop = scanner.nextLine();

            while (!loop.equalsIgnoreCase("O") && !loop.equalsIgnoreCase("N")) {
                System.out.println("Error: Please enter O or N");
                loop = scanner.nextLine();
            }

            // Perform actions for the next round of the game
            hand.discardedCard(deck);
            hand.printHiddenCards(deck); // Print the hidden cards
        }
    }
}
