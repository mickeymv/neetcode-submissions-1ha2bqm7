class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];

        for (int i=0;i<nums.length; i++) {
            for(int j=i;j<nums.length;j++) {
                int sumOfSubArray=0;
                for(int k=i;k<=j;k++) {
                    sumOfSubArray+=nums[k];
                }
                max = Math.max(max, sumOfSubArray);
            }
        }

        return max;
    }
}
