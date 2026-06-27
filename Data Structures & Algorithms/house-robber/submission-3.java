class Solution {
    public int rob(int[] nums) {

        if(nums.length==1) {
            return nums[0];
        }

        int[] maxRob = new int[nums.length];



        //let maxRob be the amount of money that can be robbed until the ith index 

        maxRob[0] = nums[0];
        maxRob[1] = Math.max(nums[0], nums[1]);

        for(int i=2;i<nums.length;i++) {
            maxRob[i]=Math.max(nums[i]+maxRob[i-2], maxRob[i-1]);
        } 

        return maxRob[nums.length-1];
    }
}
