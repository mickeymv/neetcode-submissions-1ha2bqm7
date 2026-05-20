class Solution {
    public int maxProduct(int[] nums) {
        int maxProduct = nums[0]; //default to the max value seen so far 

        int curMax = 1;
        int curMin = 1;

        for (int num : nums) {
            int origCurMax = curMax;
            curMax = Math.max(num, Math.max(origCurMax * num, curMin * num));
            curMin = Math.min(num, Math.min(origCurMax * num, curMin * num));

            maxProduct = Math.max(maxProduct, curMax);
        }

        return maxProduct;
    }
}
