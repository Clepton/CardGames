public class Main {
    public static void main(String[] args) {


        int loop=1;



            int s = 0;
            Deck deck = new Deck(); // Crée un jeu de cartes
            Hand hand = new Hand(deck); // Crée une main de cartes à partir du jeu
            Score score = new Score(s);

            //while (loop==1) {
            // Affiche la main de cartes
            hand.displayHand();
            deck.displayDeck();

            score.setScore(s);

            System.out.println(score.getScore());

            hand.discardedCard(deck);


            hand.displayHand();
            deck.displayDeck();


        //}
        
    }
}
