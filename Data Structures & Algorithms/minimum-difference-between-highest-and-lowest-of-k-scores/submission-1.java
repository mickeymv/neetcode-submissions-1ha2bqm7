class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums); // sort the scores so that the largest scores are to the right 

        int left=0,right = k-1;

        int minDiff = nums[right]-nums[left];
        left++;
        right++;
        while(left<=right && right<nums.length) {
            int diff = nums[right]-nums[left];
            minDiff = Math.min(minDiff, diff);
            left++;
            right++;
        }

        return minDiff;
    }
}