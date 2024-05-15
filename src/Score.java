public class Score extends Hand{

    private static final Deck Deck = new Deck();
    private int score;

    Score() {
        super(Deck);
        this.score = score;
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
}