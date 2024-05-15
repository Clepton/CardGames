public class Score extends Hand{

    private static final Deck Deck = new Deck();
    private int score;
    private int nbJoker = 3;

    Score() {
        super(Deck);
        this.score = score;
        this.nbJoker = 3;
    }

    public void setScore() {
        if (matchNumber()) {
            this.score = score + 5;
        }
        if (matchSuit()) {
            this.score = score + 3;
        }
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

