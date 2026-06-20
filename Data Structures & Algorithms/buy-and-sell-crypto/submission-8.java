class Solution {
    public int maxProfit(int[] prices) {
        int buyIndex=0;
        int maxProfit=0;

        for(int i=1;i<prices.length;i++){
            int currentPrice = prices[i];
            if (currentPrice<prices[buyIndex]) {
                buyIndex = i;
            }

            maxProfit = Math.max(maxProfit, currentPrice-prices[buyIndex]);
        }

        return maxProfit;
    }
}
