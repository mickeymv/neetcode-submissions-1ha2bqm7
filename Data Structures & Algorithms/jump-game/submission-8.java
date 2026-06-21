class Solution {
    
    HashMap<Integer, Boolean> canJump = new HashMap<>();
    
    public boolean canJump(int[] nums) {

        canJump.put(nums.length-1,true);

        int targetJumpIndex = nums.length-1;

        for(int i=nums.length-2;i>=0;i--) {
            int maxJumpLength = nums[i];
            if(i+maxJumpLength>=targetJumpIndex){
                canJump.put(i, true);
                targetJumpIndex=i;
            } else {
                canJump.put(i, false);
            }
        }

        return canJump.get(0);
    }
}
