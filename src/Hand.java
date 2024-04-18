import java.util.ArrayList;
import java.util.Random;

public class Hand {
    private ArrayList<Card> hand;
    private static final int HAND_SIZE = 4;

    public Hand(Deck deck) {
        hand = new ArrayList<Card>();

        // Tirez 4 cartes aléatoirement du jeu et ajoutez-les à la main
        for (int i = 0; i < HAND_SIZE; i++) {
            Card randomCard = getRandomCard(deck.getCards());
            hand.add(randomCard);
            deck.getCards().remove(randomCard); // Retirez la carte du jeu
        }

        // Ajoutez une cinquième place vide dans la main
        hand.add(null);
    }

    // Méthode pour obtenir la main de cartes
    public ArrayList<Card> getHand() {
        return hand;
    }

    // Méthode pour tirer une carte aléatoire du jeu
    private Card getRandomCard(ArrayList<Card> cards) {
        Random rand = new Random();
        int randomIndex = rand.nextInt(cards.size());
        return cards.get(randomIndex);
    }

    // Méthode pour afficher la main de cartes
    public void displayHand() {
        System.out.println("Main de cartes :");
        for (int i = 0; i < HAND_SIZE; i++) {
            Card card = hand.get(i);
            if (card != null) {
                System.out.println("Carte " + (i+1) + ": " + card.getNumber() + " de " + card.getSuit());
            } else {
                System.out.println("Place " + (i+1) + ": Vide");
            }
        }
        System.out.println("Place 5: Vide");
    }
}
