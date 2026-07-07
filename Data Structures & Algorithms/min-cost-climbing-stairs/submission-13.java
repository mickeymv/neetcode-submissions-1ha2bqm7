class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] minCostToGetToFloor = new int[cost.length+1];

        minCostToGetToFloor[0]=0; 
        minCostToGetToFloor[1]=0; 
        //^ since we can start at either the 0th or 1st floors 

        for (int floor=2;floor<cost.length+1;floor++) {
            minCostToGetToFloor[floor] = Math.min(minCostToGetToFloor[floor-2]+cost[floor-2],
                                                  minCostToGetToFloor[floor-1]+cost[floor-1]);
        }

        return minCostToGetToFloor[cost.length];
    }
}
