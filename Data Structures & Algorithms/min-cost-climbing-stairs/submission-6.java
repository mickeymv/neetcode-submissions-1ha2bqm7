class Solution {

    Map<Integer, Integer> mem = new HashMap<>();

    public int minCostClimbingStairs(int[] cost) {
        return Math.min(minCost(0, cost), minCost(1, cost));
    }

    public int minCost(int index, int[] cost) {
        if (index>=cost.length) {
            return 0;
        }

        if (mem.containsKey(index)) {
            return mem.get(index);
        }

        int costOfThisStep = cost[index];

        mem.put(index+1, minCost(index+1, cost));
        mem.put(index+2, minCost(index+2, cost));

        mem.put(index, costOfThisStep + Math.min(mem.get(index+1),mem.get(index+2)));

        return mem.get(index);
    }
}
