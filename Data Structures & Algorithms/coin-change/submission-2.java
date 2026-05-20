class Solution {
    int[] minimumCoins = null;

    public int coinChange(int[] coins, int totalAmount) {
        minimumCoins = new int[totalAmount+1]; // since we need 0+1...totalAmount spaces
        Arrays.fill(minimumCoins, totalAmount+1); //sufficiently high value of coins 

        //base case of number of coins to get amount 0 
        minimumCoins[0] = 0;

        //build out the minimum coins required array from bottom up 
        for (int amount = 1; amount <= totalAmount; amount++) {
            //try with every coin 
            for (int coin : coins) {
                int remainderAfterChosingThisCoin = amount - coin;
                if (remainderAfterChosingThisCoin >= 0) {
                    //can use this coin 
                    minimumCoins[amount] = Math.min(minimumCoins[amount], 
                    1 + minimumCoins[remainderAfterChosingThisCoin]); //1 is for this coin chosen, a-c is the minimum coins required for the remainder
                }
            }
        }

        if (minimumCoins[totalAmount] == totalAmount+1) {
            return -1;
        } else {
            return minimumCoins[totalAmount];
        }
    }
}
