class Solution {
    
    TreeMap<Integer, Integer> cardToCount = new TreeMap<>();

    public boolean isNStraightHand(int[] hand, int groupSize) {
        for(int card:hand) {
            int currentCardCount = cardToCount.getOrDefault(card, 0);
            cardToCount.put(card, currentCardCount+1);
        }


        int cardsCounted=0;

        while(cardsCounted<hand.length) {
            int card = cardToCount.firstKey();
            for(int i=0;i<groupSize;i++) {
                if(!cardToCount.containsKey(card)) {
                    return false;
                } else {
                    int cardCount = cardToCount.get(card);
                    cardCount--;
                    if (cardCount == 0) {
                        cardToCount.remove(card);
                    } else {
                        cardToCount.put(card, cardCount);
                    }
                }
                card++; // increase the card to get next card in the straight 
            }
            cardsCounted+=groupSize;
        }

        return true;
    }
}
