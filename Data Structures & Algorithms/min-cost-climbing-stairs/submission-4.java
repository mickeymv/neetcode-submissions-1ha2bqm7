class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] minCostToReachIndex = new int[cost.length+1];

        minCostToReachIndex[0] = 0;
        minCostToReachIndex[1] = 0;

        for (int index = 2; index<=cost.length;index++) {
            minCostToReachIndex[index] = Math.min(minCostToReachIndex[index-1]+cost[index-1],
                                                  minCostToReachIndex[index-2]+cost[index-2]
            );
        }

        return minCostToReachIndex[cost.length];
    }
}
