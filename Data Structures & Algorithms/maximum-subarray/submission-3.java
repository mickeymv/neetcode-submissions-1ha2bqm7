class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];

        for (int i=0;i<nums.length; i++) {
            int sumOfSubArray=0;
            for(int j=i;j<nums.length;j++) {
                sumOfSubArray += nums[j];
                max = Math.max(max, sumOfSubArray);
            }
        }

        return max;
    }
}
