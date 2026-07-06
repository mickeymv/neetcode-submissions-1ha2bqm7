class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];//start from 0th step till the nth step 

        dp[0] = 1;//there is no ways to climb, we are already there
        dp[1] = 1;//there is only one way to climb 
        
        for(int i=2;i<=n;i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
}
