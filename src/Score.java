public class Score {
    //test
    private int score;
    private int nbJoker;

    Score() {
        this.score = 0; // Initialiser le score à zéro dans le constructeur
        this.nbJoker = 3;
    }

    public void setScore(Hand hand) {
        if (hand.matchNumber()) {
            this.score += 5; // Ajouter 5 points si les cartes correspondent par numéro
        }
        if (hand.matchSuit()) {
            this.score += 3; // Ajouter 3 points si les cartes correspondent par couleur
        }
    }

    public void resetScore() {
        this.score = 0; // Réinitialiser le score à zéro
    }

    public int getScore() {
        return score;
    }

    public void setJoker() {
        nbJoker = nbJoker - 1;
    }
    public int getJoker() {
        return nbJoker;
    }
}