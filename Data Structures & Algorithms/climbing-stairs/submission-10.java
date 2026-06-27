class Solution {

    int[] dp;

    public int climbStairs(int n) {
        dp = new int[n+1];
        return dfs(n);
    }

    public int dfs(int n) {

        if(dp[n]!=0) {
            return dp[n];
        }

        if(n<=0) {
            return 0;
        }

        if(n<=3) {
            return n;
        }

        dp[n-1] = dfs(n-1);
        dp[n-2] = dfs(n-2);
        dp[n] = dp[n-1] + dp[n-2];


        return dp[n];
    }
}
