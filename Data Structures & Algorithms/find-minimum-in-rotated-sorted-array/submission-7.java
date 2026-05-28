class Solution {
    public int findMin(int[] nums) {
        int left=0, right = nums.length-1;

        while(left<right) {
            int mid=(left+right)/2;

            if (nums[mid]<nums[right]) {
                //we are in the sorted/increasing portion of the array, go left to findMin 
                right = mid;
            } else {
                //we are in the un-sorted portion of the array, go right to find min 
                left = mid+1;
            }
        }

        return nums[left];
    }
}
