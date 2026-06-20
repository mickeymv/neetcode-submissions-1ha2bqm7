class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit=0;

        for(int buy = 0;buy<prices.length;buy++){
            for(int sell=buy+1;sell<prices.length;sell++){
                int buyPrice = prices[buy];
                int sellPrice = prices[sell];
                maxProfit = Math.max(maxProfit, sellPrice-buyPrice);
            }
        }

        return maxProfit;
    }
}
