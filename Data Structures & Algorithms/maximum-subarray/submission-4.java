class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];

        int curSum = 0;

        for (int num : nums) {
            if (curSum < 0) {
                curSum = 0;
            }
            curSum += num;
            max = Math.max(curSum, max);
        }

        return max;
    }
}
