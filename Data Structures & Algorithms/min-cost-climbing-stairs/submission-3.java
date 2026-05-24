class Solution {
    int[] minCostAtIndex;

    public int minCostClimbingStairs(int[] cost) {
        minCostAtIndex = new int[cost.length+2];

        Arrays.fill(minCostAtIndex, -1);

        return Math.min(minCostClimbingStairs(0, cost),
                        minCostClimbingStairs(1, cost));
    }

    public int minCostClimbingStairs(int index, int[] cost) {
        //base case is when we go past the last index in cost 
        if (index >= cost.length) {
            return 0;
        }

        if (minCostAtIndex[index] != -1) {
            return minCostAtIndex[index];
        }

        int costFromThisIndex = cost[index];

        minCostAtIndex[index+1] =  minCostClimbingStairs(index+1, cost);
        minCostAtIndex[index+2] =  minCostClimbingStairs(index+2, cost);


        return costFromThisIndex + Math.min(minCostAtIndex[index+1],
                                            minCostAtIndex[index+2]);
    }
}
