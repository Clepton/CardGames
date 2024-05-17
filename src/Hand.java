import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;


public class Hand {
    //test
    private ArrayList<Card> hand;
    private ArrayList<Card> HiddenCards;
    public static final int HAND_SIZE = 4;

    public Hand(Deck deck) {
        hand = new ArrayList<Card>();
        HiddenCards = new ArrayList<Card>();

        // Draw 4 random cards from the deck and add them to the hand
        for (int i = 0; i < HAND_SIZE; i++) {
            Card randomCard = getRandomCard(deck.getCards());
            hand.add(randomCard);
            deck.getCards().remove(randomCard); // Remove the card from the deck
        }
    }

    // Method to get the hand of cards
    public ArrayList<Card> getHand() {
        return hand;
    }

    // Method to get the hidden cards
    public ArrayList<Card> getHiddenCards() {
        return HiddenCards;
    }

    // Method to draw a random card from the deck
    private Card getRandomCard(ArrayList<Card> cards) {
        Random rand = new Random();
        int randomIndex = rand.nextInt(cards.size());
        return cards.remove(randomIndex); // Remove and return the random card
    }

    // Method to hide the last card behind the third one
    public void HideLastCard() {
        if (hand.size() == HAND_SIZE + 1) {
            HiddenCards.add(hand.remove(HAND_SIZE)); // Remove the last card to hidden cards and add it to another listt HiddenCards
        }
    }

    // Method to display the hand of cards
    public void displayHand() {
        System.out.println("Cards in Hand :");
        for (int i = 0; i < HAND_SIZE; i++) {
            Card card = hand.get(i);
            if (card != null) {
                System.out.println("Card n° " + (i+1) + ": " + card.getNumber() + " of " + card.getSuit());
            } else {
                System.out.println("Place " + (i+1) + ": None");
            }
        }
    }

    public boolean matchNumber() {
        Card card1 = hand.get(0);
        Card card4 = hand.get(3);
        return card1.getNumber().equals(card4.getNumber());
    }

    public boolean matchSuit() {
        Card card1 = hand.get(0);
        Card card4 = hand.get(3);
        return card1.getSuit().equals(card4.getSuit());
    }

    public void discardedCard(Deck deck) {
        if (matchNumber()) {

            hand.remove(0);
            hand.remove(0);
            hand.remove(0);
            hand.remove(0);


            Card card1 = getRandomCard(deck.getCards());
            hand.add(0, card1);
            deck.getCards().remove(card1); // Remove the card 1 from the deck


            Card card2 = getRandomCard(deck.getCards());
            hand.add(1, card2);
            deck.getCards().remove(card2); // Remove the card 2 from the deck

            Card card3 = getRandomCard(deck.getCards());
            hand.add(2, card3);
            deck.getCards().remove(card3); // Remove the card 3 from the deck

            Card card4 = getRandomCard(deck.getCards());
            hand.add(3, card4);
            deck.getCards().remove(card4); // Remove the card 4 from the deck

        } else if (matchSuit()) {
            // Reorder the hand based on the matchSuit condition
            Card firstCard = hand.get(0);
            Card lastCard = hand.get(3);

            // Tirer 2 nouvelles cartes et les ajouter a la première et deuxième place
            Card newCard1 = getRandomCard(deck.getCards());
            Card newCard2 = getRandomCard(deck.getCards());

            hand.remove(1);
            hand.remove(1);

            hand.add(0, newCard1);  // Ajouter la première nouvelle carte en 1ère place
            hand.add(1, newCard2);  // Ajouter la deuxième nouvelle carte en 2ème place
        }

        else {
            // If matchNumber or matchSuit aren't true we hide the last card behind the third one(which mean the 4th)
            if (hand.size() == HAND_SIZE) {
                Card lastCard = hand.remove(3); // Remove the last card from the hand
                HiddenCards.add(lastCard); // we add the last card to hidden ones


            }
            // Draw a new card from the deck to replace the discarded one
            Card newCard = getRandomCard(deck.getCards());
            hand.add(0, newCard);
        }


    }
    public void printHiddenCards(Deck deck) {
        if (!HiddenCards.isEmpty()) {
            System.out.println("Hidden Cards:");
            for (int i = 0; i < HiddenCards.size(); i++) {
                Card card = HiddenCards.get(i);
                System.out.println("Hidden Card n° " + (i+1) + ": " + card.getNumber() + " of " + card.getSuit());
            }
        } else {
            System.out.println("No cards are hidden.");
        }
        System.out.println("\n\n");
    }

    public ArrayList<Card> getCards() {
        return hand;
    }

    public void ApplyJoker(Deck deck) {
        Card firstCard = hand.get(0);
        Card lastCard = hand.get(3);

        // Tirer 2 nouvelles cartes et les ajouter a la première et deuxième place
        Card newCard1 = getRandomCard(deck.getCards());
        Card newCard2 = getRandomCard(deck.getCards());

        hand.remove(1);
        hand.remove(1);

        hand.add(0, newCard1);  // Ajouter la première nouvelle carte en 1ère place
        hand.add(1, newCard2);  // Ajouter la deuxième nouvelle carte en 2ème place
    }
}