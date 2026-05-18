class Solution {
    public int rob(int[] nums) {
        int[] maxRobbed = new int[nums.length];
        maxRobbed[0] = nums[0];
        if (nums.length > 1) {
            maxRobbed[1] = Math.max(nums[1], maxRobbed[0]);
        }
        for (int house=2; house<nums.length; house++) {
            maxRobbed[house] = Math.max(nums[house]+maxRobbed[house-2], maxRobbed[house-1]);
        }
        return maxRobbed[nums.length-1];
    }
}
