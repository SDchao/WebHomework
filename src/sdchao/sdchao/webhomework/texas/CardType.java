package sdchao.webhomework.texas;

public class CardType {
    public static final int LOOSE = 0;
    public static final int ONE_PAIR = 1;
    public static final int TWO_PAIRS = 2;
    public static final int THREE_OF_A_KIND = 3;
    public static final int STRAIGHT = 4;
    public static final int FLUSH = 5;
    public static final int STRAIGHT_FLUSH = 6;

    private int type;
    private int maxNum;

    public CardType(int type, int maxNum) {
        this.type = type;
        this.maxNum = maxNum;
    }

    public int getType() {
        return type;
    }

    public int getMaxNum() {
        return maxNum;
    }
}
