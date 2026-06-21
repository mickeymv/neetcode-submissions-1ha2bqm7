class Solution {
        
    public boolean canJump(int[] nums) {

        int targetJumpIndex = nums.length-1;

        for(int i=nums.length-2;i>=0;i--) {
            int maxJumpLength = nums[i];
            if(i+maxJumpLength>=targetJumpIndex){
                targetJumpIndex=i;
            } 
        }

        return targetJumpIndex==0;
    }
}
