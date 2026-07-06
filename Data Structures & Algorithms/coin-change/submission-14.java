class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] minCoinsToCalculateAmount = new int[amount+1];

        Arrays.fill(minCoinsToCalculateAmount, amount+1);

        minCoinsToCalculateAmount[0]=0;//base case

        for(int amountToGet=1;amountToGet<=amount;amountToGet++) {
            for(int coinAmount:coins) {
                if(coinAmount<=amountToGet) {
                    minCoinsToCalculateAmount[amountToGet] = Math.min(minCoinsToCalculateAmount[amountToGet],
                                                                      1 + minCoinsToCalculateAmount[amountToGet-coinAmount]);
                }
            }
        }

        if(minCoinsToCalculateAmount[amount]!=amount+1) {
            return minCoinsToCalculateAmount[amount];
        } else {
            return -1;
        }
    }
}
