public class Score extends Hand{

    private static final Deck Deck = new Deck();
    private int score;

    Score(int score) {
        super(Deck);
        this.score = score;
    }

    public void setScore(int score) {
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
}
