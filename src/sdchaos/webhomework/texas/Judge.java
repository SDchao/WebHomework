package sdchaos.webhomework.texas;

import java.util.*;

public class Judge {

    public static final int PLAYER1_WIN = 0;
    public static final int PLAYER2_WIN = 1;
    public static final int TIE = -1;
    
    public int Compare(Card[] player1Cards, Card[] player2Cards) {
        CardType type1 = JudgeCardType(player1Cards);
        CardType type2 = JudgeCardType(player2Cards);

        if(type1.getType() > type2.getType()) {
            return PLAYER1_WIN;
        }
        else if(type1.getType() < type2.getType()) {
            return PLAYER2_WIN;
        }
        else {
            if(type1.getMaxRank() > type2.getMaxRank()) {
                return PLAYER1_WIN;
            }
            else if(type1.getMaxRank() < type2.getMaxRank()) {
                return PLAYER2_WIN;
            }
            else {
                return TIE;
            }
        }
    }

    private CardType JudgeCardType(Card[] cards) {
        // Get Max Rank
        int maxRank = GetMaxRank(cards);

        // Judge the flush
        boolean hasFlush = true;
        String firstSuit = cards[0].getSuit();
        for(int i = 1; i < 4; i++) {
            if(!cards[i].getSuit().equals(firstSuit)) {
                hasFlush = false;
                break;
            }
        }

        //Judge the straight
        boolean hasStraight = true;
        int firstRank = cards[0].getRank();
        for(int i = 1; i < 4; i++) {
            if(cards[i].getRank() != firstRank) {
                hasStraight = false;
                break;
            }
        }

        if(hasFlush && hasStraight) {
            return new CardType(CardType.STRAIGHT_FLUSH, maxRank);
        }
        else if(hasFlush) {
            return new CardType(CardType.FLUSH, maxRank);
        }
        else if(hasStraight) {
            return new CardType(CardType.STRAIGHT, maxRank);
        }

        TreeMap<Integer, Integer> rankMap = new TreeMap<>();    // Rank : Count
        for(int i = 0; i <5; i++) {
            int nowRank = cards[i].getRank();
            if(!rankMap.containsKey(nowRank)) {
                rankMap.put(nowRank, 1);
            }
            else {
                rankMap.put(nowRank, rankMap.get(nowRank) + 1);
            }
        }

        // value sort

        Comparator<Map.Entry<Integer, Integer>> valueComparator = (o1, o2) -> o2.getValue() - o1.getValue();

        List<Map.Entry<Integer, Integer>> rankMapEntryList = new ArrayList<>(rankMap.entrySet());

        rankMapEntryList.sort(valueComparator);

        // rankMapEntryList is sorted by value (Descending order)

        if(rankMapEntryList.get(0).getValue() >= 3) {
            return new CardType(CardType.THREE_OF_A_KIND, rankMapEntryList.get(0).getKey());
        }
        else if(rankMapEntryList.get(0).getValue() == 2) {
            if(rankMapEntryList.get(1).getValue() == 2) {
                int rank1 = rankMapEntryList.get(0).getKey();
                int rank2 = rankMapEntryList.get(1).getKey();
                maxRank = Math.max(rank1, rank2);
                return new CardType(CardType.TWO_PAIRS, maxRank);
            }
            else {
                return new CardType(CardType.ONE_PAIR, rankMapEntryList.get(0).getKey());
            }
        }
        else {
            return new CardType(CardType.LOOSE, maxRank);
        }
    }

    private int GetMaxRank(Card[] cards) {
        if(cards.length < 5)
            return 0;

        int maxRank = cards[0].getRank();
        for(int i = 1; i < 5; i++) {
            if(cards[i].getRank() > maxRank)
                maxRank = cards[i].getRank();
        }

        return maxRank;
    }
}
