class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return ways(0, nums, target);
    }

    public int ways(int index, int[] nums, int target) {
        if (target==0 && index==nums.length) {
            return 1;
            //we found a way to sum
        }

        if (index>=nums.length) {
            return 0;
            //we didn't find a way
        }

        //there are two choices we can make, to add the number, or subtract it 

        int num = nums[index];

        return ways(index+1, nums, target-num) + ways(index+1, nums, target+num);

    }
}
