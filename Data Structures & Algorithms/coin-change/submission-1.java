class Solution {
    int[] minimumCoinsForAmount = null;

    public int coinChange(int[] coins, int amount) {
        minimumCoinsForAmount = new int[amount+1];
        Arrays.fill(minimumCoinsForAmount, amount+1);

        //base condition, minimum coins required to get amount 0 is 0 
        minimumCoinsForAmount[0] = 0;

        for (int candidateAmount = 1; candidateAmount <= amount ; candidateAmount++) {
            for (int coin : coins) {
                if (candidateAmount - coin >= 0) {
                    minimumCoinsForAmount[candidateAmount] = Math.min(minimumCoinsForAmount[candidateAmount], 1+minimumCoinsForAmount[candidateAmount-coin]);
                }
            }
        }
        if (minimumCoinsForAmount[amount] == amount+1) {
            return -1;
        } else {
            return minimumCoinsForAmount[amount];
        }
    }
}
