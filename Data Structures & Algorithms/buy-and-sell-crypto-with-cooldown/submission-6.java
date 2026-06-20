class Solution {

    HashMap<String,Integer> cache = new HashMap<>();

    public int maxProfit(int[] prices) {
        return maxProfit(0, prices, true);
    }

    public int maxProfit(int index, int[] prices, boolean canBuy) {
        if(index>=prices.length){
            return 0;
        }
        String key = index+"-"+canBuy;
        if(cache.get(key)!=null){
            return cache.get(key);
        }

        int cooldown = maxProfit(index+1, prices, canBuy);

        if (canBuy) {
            //can buy a coin, 
            //can choose to either buy at the current price 
            //or move to the next day (cooldown)
            int buy = maxProfit(index+1, prices, false) - prices[index];

            cache.put(key, Math.max(buy,cooldown));

            return cache.get(key);
        } else {
            //can sell a coin and have a cooldown, 
            //or move to the next day (cooldown) 

            int sell = maxProfit(index+2, prices,true) + prices[index];
            
            cache.put(key, Math.max(sell,cooldown));

            return cache.get(key);
        }
    }
}
