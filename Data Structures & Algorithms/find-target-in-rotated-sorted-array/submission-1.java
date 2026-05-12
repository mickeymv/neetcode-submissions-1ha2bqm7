class Solution {
    public int search(int[] nums, int target) {
        int noOfPossibleRotations = nums.length;
        
        if (nums.length == 1) {
            if (nums[0] == target) {
                return 0;
            } else {
                return -1;
            }
        }

        /*
        the core idea is that in a sorted but possibly rotated array, at least 
        one half of the array is always sorted. we can use this to find the target element 
        */

        int left = 0;
        int right = nums.length - 1;


        while (left <= right) {
            int mid = (left+right)/2;

            if (nums[mid] == target) {
                return mid;
            }
        
            if (nums[left] <= nums[mid]) {
                //left half is sorted
                //check if target is in the sorted left half or unsorted right half 
                if (target>=nums[left] && target<=nums[mid]) {
                    right = mid-1;
                } else {
                    left = mid+1;
                }
            } else {
                //right half is sorted
                //check if target is in the sorted right half or unsorted left half 

                if (target>=nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }

            }
        }

        return -1;
    }
}
