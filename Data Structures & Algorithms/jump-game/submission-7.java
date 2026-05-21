class Solution {
    Set<Integer> canJump = new HashSet<>();
    public boolean canJump(int[] nums) {
        //we move from the end 
        //of the array to the start, which tells us if we can reach the end 
        //from the current index
        int indexWhichCanReachEnd = nums.length-1;

        for (int index = nums.length-2; index >=0; index--) {
            int maxJumpLength = nums[index];
            int minimumRequiredJumpLength = indexWhichCanReachEnd - index;

            if (minimumRequiredJumpLength <= maxJumpLength) {
                indexWhichCanReachEnd = index;
            }
        }

        return indexWhichCanReachEnd == 0;
    }
}
