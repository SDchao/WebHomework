package sdchaos.webhomework.texas;

public class Card {
    private int rank;
    private String suit;

    public Card(String rank, String suit) {
        Character rankChar = rank.charAt(0);
        if(rankChar >= '2' && rankChar <= '9')
            this.rank = Integer.parseInt(String.valueOf(rankChar));
        else
            switch (rankChar) {
                case 'T':
                    this.rank = 10;
                    break;
                case 'J':
                    this.rank = 11;
                    break;
                case 'Q':
                    this.rank = 12;
                    break;
                case 'K':
                    this.rank = 13;
                    break;
                case 'A':
                    this.rank = 14;
                    break;
                default:
                    this.rank = 0;
                    break;
            }
        this.suit = suit;
    }

    public int getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }
}
