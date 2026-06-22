class Solution {
    public int removeElement(int[] nums, int val) {
        int elementsNotEqualToVal = 0 ;

        

        for(int i=0;i<nums.length;i++) {
            if (nums[i]!=val) {
                nums[elementsNotEqualToVal++]=nums[i];
            }

        }

        return elementsNotEqualToVal;
    }
}