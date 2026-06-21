class Solution {
    public int jump(int[] nums) {
        int minJumps=0; //increment this whenever we go up a level (or jump)

        int left=0,right=0;

        while(left<nums.length-1 && right<nums.length-1) {
            int nextLeft=left, nextRight=right;
            for (int i =left;i<=right;i++) {
                int maxJumpLength = nums[i];
                nextRight = Math.max(nextRight, i+maxJumpLength);
                if (maxJumpLength>0) {
                    nextLeft = Math.max(nextLeft, i+1);
                }
            }
            left = nextLeft;
            right = nextRight;
            minJumps++;
        }

        return minJumps;
    }
}
