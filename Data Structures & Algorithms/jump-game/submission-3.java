class Solution {
    Map<Integer, Boolean> canJump = new HashMap<>();

    public boolean canJump(int[] nums) {
        return canJump(0, nums);   
    }

    public boolean canJump(int index, int[] nums) {
        //base case if we reached the last index, return true 
        if (index == nums.length-1) {
            return true;
        }

        if (index >= nums.length) { //we jumped past last index 
            return false;
        }

        if(canJump.containsKey(index)) {
            return canJump.get(index);
        }

        for (int jump = 1; jump<=nums[index];jump++) {
            if (canJump(index+jump, nums)) {
                canJump.put(index, true);
                return true;
            }
        }

        canJump.put(index, false);
        return false;
    }
}
