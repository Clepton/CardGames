public class Score {

    private int score;

    Score(int score) {
        this.score = score;
    }

    public void setScore(int score) {
        this.score = score + 1;
    }

    public int getScore() {
        return score;
    }
}
