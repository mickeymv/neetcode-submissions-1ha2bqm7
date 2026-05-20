class Solution {
    public int maxProduct(int[] nums) {
        int maxProduct = nums[0]; //defaults to first element 

        int curMin = 1, curMax = 1;

        for (int num : nums) {
            int origCurMax = curMax;

            curMax = Math.max(num, Math.max(num*origCurMax, num*curMin));
            curMin = Math.min(num, Math.min(num*origCurMax, num*curMin));

            maxProduct = Math.max(maxProduct, curMax);
        } 

        return maxProduct;
    }
}
