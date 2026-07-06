class Solution {
    public int coinChange(int[] coins, int amount) {
        //we start with a dp array, where dp[i] is the 
        //min amount of coins needed to reach amount i 

        int[] dp = new int[amount+1];//since we are going from 0 to amount 

        dp[0]=0;//it takes 0 coins to get 0

        for(int amountToGet=1; amountToGet<=amount;amountToGet++) {
            int minCoinsUsedForAmount = amount+1;
            for(int coin:coins) {
                int coinsUsed=0;
                if(coin<=amountToGet && dp[amountToGet-coin]!=-1) {
                    coinsUsed = 1 + dp[amountToGet-coin];
                    minCoinsUsedForAmount = Math.min(minCoinsUsedForAmount, coinsUsed);
                }
            }
            if (minCoinsUsedForAmount==amount+1) {
                dp[amountToGet]=-1;
            } else {
                dp[amountToGet] = minCoinsUsedForAmount;
            }
        }

        return dp[amount];
    }
}
