import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        int s=0;

        String loop = "O";

        Deck deck = new Deck(); // Crée un jeu de cartes
        Hand hand = new Hand(deck); // Crée une main de cartes à partir du jeu
        Score score = new Score(s);



        while ("O".equalsIgnoreCase(loop)) {




            // Affiche la main de cartes
            hand.displayHand();

            score.setScore(s);

            System.out.println(score.getScore());
            Scanner scanner = new Scanner(System.in);



            // Demander à l'utilisateur d'entrer du texte
            System.out.print("Continuer à jouer ? O/N : ");
            loop = scanner.nextLine();


            while (!loop.equalsIgnoreCase("O") && !loop.equalsIgnoreCase("N")) {
                System.out.println("Erreur : Veuillez entrer O ou N");
                loop = scanner.nextLine();
            }


    }

}

}
