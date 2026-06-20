class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit=0;

        //I only have to keep track of the lowest day to buy 
        //any day after that increases I can sell 
        //so I can have a array, lowestToBuy, which tracks the lowest
        //price until that index. 
        //similarly, I can have another array highestToSell, which tracks the 
        //highest price until then to sell (computed from the back in reverse) 
        
        int[] lowestToBuy = new int[prices.length];
        int[] highestToSell = new int[prices.length];

        int lowestToBuyPrice=101;
        int highestToSellPrice=-1;

        for(int i=0; i<prices.length; i++) {
            lowestToBuyPrice = Math.min(prices[i], lowestToBuyPrice);
            lowestToBuy[i] = lowestToBuyPrice;
        }

        for(int i=prices.length-1; i>=0; i--) {
            highestToSellPrice = Math.max(prices[i], highestToSellPrice);
            highestToSell[i] = highestToSellPrice;
        }

        for(int i=0;i<prices.length;i++) {
            maxProfit = Math.max(maxProfit, highestToSell[i]-lowestToBuy[i]);
        }

        return maxProfit;
    }
}
