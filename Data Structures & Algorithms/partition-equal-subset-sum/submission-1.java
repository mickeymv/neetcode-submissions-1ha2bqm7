class Solution {
    public boolean canPartition(int[] nums) {
        //iterate through the nums to get the total sum 

        int totalSum = 0;

        for(int num:nums){
            totalSum+=num;
        }

        if (totalSum%2!=0) {
            //totalSum is odd, we can't have subsets 
            //that are of equal sum to each other
            return false;
        }

        int halfSum = totalSum/2;

        return canPartition(0, nums, halfSum);
    }

    public boolean canPartition(int index, int[] nums, int sum) {
        if (index>=nums.length) {
            return false;
        }
        
        if (sum==0) {
            return true;
        }

        if (sum<0) {
            return false;
        }

        //we can either choose the number at index or not 
        int num = nums[index];

        if (canPartition(index+1, nums, sum-num)) {
            return true;
        } else {
            return canPartition(index+1, nums, sum);
        }
    }
}
