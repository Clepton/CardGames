import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private static final int NB_CARDS = 52;

    private ArrayList<Card> cards;

    public Deck() {
        this.cards = new ArrayList<Card>();
        // Construire le jeu de cartes, pour chaque nombre de 2 à 14 (inclus)..
        for (int number = 1; number <= 13; number++) {
            String[] suits = {"Clover", "Heart", "Spike", "Diamond"};
            for (String suit : suits) {
                String faceCard = verifyName(number); // Obtenir le nom de la carte face
                cards.add(new Card(number, suit)); // Ajouter la nouvelle carte au jeu
            }
        }
        // Mélanger le jeu de cartes pour que les cartes aient un nouvel ordre
        Collections.shuffle(cards);
    }

    // Méthode auxiliaire pour vérifier le nom de la carte face en fonction du nombre
    private String verifyName(int number) {
        switch (number) {
            case 11:
                return "Valet";
            case 12:
                return "Roi";
            case 13:
                return "Reine";
            case 14:
                return "As";
            default:
                return String.valueOf(number);
        }
    }

    // Méthode pour obtenir le jeu de cartes
    public ArrayList<Card> getCards() {
        return cards;
    }

    // Méthode pour afficher le jeu de cartes
    public void displayDeck() {
        System.out.println("Jeu de cartes :");
        for (Card card : cards) {
            System.out.println(card.getNumber() + card.getSymbol(card.getSuit()));
        }
    }
}
