import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;


public class Deck {
    //test
    private ArrayList<Card> deck;

    private static final int NB_CARDS = 52;

    public Deck() {
        deck = new ArrayList<Card>();

        String[] Number = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String[] Suit = {"C", "D", "H", "S"};

        for (String suit : Suit) {
            for (String number : Number) {
                Card card = new Card(number, suit);
                deck.add(card);
            }
        }
    }

    public ArrayList<Card> getCards() {
        return deck;
    }

    public void displayDeck() {
        System.out.println("Jeu de cartes :");
        for (Card card : deck) {
            System.out.println(card.getNumber() + card.getSuit());
        }
    }


    public int size() {
        return deck.size();
    }
}