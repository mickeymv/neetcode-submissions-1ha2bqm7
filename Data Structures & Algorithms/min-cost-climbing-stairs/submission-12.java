class Solution {
    int[] dp;
    public int minCostClimbingStairs(int[] cost) {
        
        int n = cost.length;
        
        dp=new int [cost.length+1];

        //let dp[i] be the min cost of climbing to the ith floor 

        //we need to find dp[n-1]

        return dfs(n, cost);
    }

    public int dfs(int n, int[] cost) {

        if(n<=1) {
            return 0;//no cost to start at the 0th or 1st step
        }

        if(dp[n]!=0) {
            return dp[n];
        }

        dp[n] = Math.min(dfs(n-1,cost) + cost[n-1],
                            dfs(n-2,cost) + cost[n-2]);


        return dp[n];
    }
}
