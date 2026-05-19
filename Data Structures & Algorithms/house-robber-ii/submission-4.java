class Solution {
    public int rob(int[] loot) {

        if (loot.length == 1) {
            return loot[0];
        }

        return Math.max(
            robHelper(Arrays.copyOfRange(loot, 1, loot.length)), //choose last house, not first house
            robHelper(Arrays.copyOfRange(loot, 0, loot.length-1)) //choose first house, not last house
            );
    }

    public int robHelper(int[] loot) {
        int[] maxRobbed = null;
        if (loot != null) {
            maxRobbed = new int[loot.length];
        }
        if (loot.length == 0) {
            return 0;
        }
        
        maxRobbed[0] = loot[0];

        if (loot.length > 1) {
           maxRobbed[1] = Math.max(loot[1], maxRobbed[0]);
        }
        for (int house=2; house<loot.length; house++) {
            maxRobbed[house] = Math.max(loot[house] + maxRobbed[house-2], maxRobbed[house-1]);
        }

        return maxRobbed[loot.length-1];
    }
}
