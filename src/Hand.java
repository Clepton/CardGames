import java.util.ArrayList;
import java.util.Objects;
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
    }

    // Méthode pour obtenir la main de cartes
    public ArrayList<Card> getHand() {
        return hand;
    }

    // Méthode pour tirer une carte aléatoire du jeu
    private Card getRandomCard(ArrayList<Card> cards) {
        Random rand = new Random();
        int randomIndex = rand.nextInt(cards.size());
        return cards.remove(randomIndex); // Retirez et renvoyez la carte aléatoire
    }

    // Méthode pour afficher la main de cartes
    public void displayHand() {
        System.out.println("Cards in Hand :");
        for (int i = 0; i < HAND_SIZE; i++) {
            Card card = hand.get(i);
            if (card != null) {
                System.out.println("Carte " + (i+1) + ": " + card.getNumber() + " de " + card.getSuit());
            } else {
                System.out.println("Place " + (i+1) + ": None");
            }
        }
}


    public boolean matchNumber(){

        Card card1 = hand.get(0);
        Card card4 = hand.get(3);

        return card1.getNumber() == card4.getNumber();

    }


    public boolean matchSuit(){
        Card card1 = hand.get(0);
        Card card4 = hand.get(3);

        return Objects.equals(card1.getSuit(), card4.getSuit());
    }

    public void discardedCard(Deck deck){

        if (matchNumber()) {

            Card card1 = getRandomCard(deck.getCards());
            hand.add(0, card1);
            deck.getCards().remove(card1); // Retirer la carte du jeu

        }

        if (matchSuit()){

            // Stocker la première et dernière carte
            Card firstCard = hand.get(0);
            Card lastCard = hand.get(3);

            // Retirer la deuxième et la troisième carte
            hand.remove(1);
            hand.remove(1);

            // Ajouter la première carte en première position
            hand.add(2, firstCard);

            // Ajouter la dernière carte en deuxième position
            hand.add(3, lastCard);

            // Tirer 2 nouvelles cartes et les ajouter en troisième et quatrième position
            Card newCard1 = getRandomCard(deck.getCards());
            Card newCard2 = getRandomCard(deck.getCards());

            hand.add(0, newCard1);
            hand.add(1, newCard2);




        }


    }


}