public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck(); // Crée un jeu de cartes
        Hand hand = new Hand(deck); // Crée une main de cartes à partir du jeu
        // Affiche la main de cartes
        hand.displayHand();
        deck.displayDeck();

    }
}
