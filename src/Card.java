public class Card {

    private int Number;
    private String Suit;

    public Card(int Number, String Suit) {
        this.Number = Number;
        this.Suit = Suit;
    }

    private String verifyName(int Number) {

        switch (Number) {
            case 11:
                return "Valet";
            case 12:
                return "Roi";
            case 13:
                return "Reine";
            case 14:
                return "As";
            default:

                return String.valueOf(Number);
        }
    }

    public int getNumber() {
        return Number;
    }

    public String getSuit() {
        return Suit;
    }
}
