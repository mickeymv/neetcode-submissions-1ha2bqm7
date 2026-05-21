class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] lis = new int[nums.length];

        //for the base case, we choose the lis of length one 
        //which is the last element in the array
        lis[nums.length-1] = 1;

        for (int currentIndex = nums.length-2; currentIndex >= 0; currentIndex--) {
            int lisAtCurrentIndex = 1;//by default we choose this subsequence of one element 
            int numAtCurrentIndex = nums[currentIndex];
            //check current number against the numbers in the rest of the array 

            for (int laterIndex = currentIndex+1; laterIndex<nums.length; laterIndex++) {
                int numAtLaterIndex = nums[laterIndex];
                if (numAtCurrentIndex < numAtLaterIndex) {
                    lisAtCurrentIndex = Math.max(lisAtCurrentIndex, 1+lis[laterIndex]);
                }
            }
            lis[currentIndex] = lisAtCurrentIndex;
        }

        int longestIncreasingSubindex = 1;

        for(int i=0;i<nums.length;i++) {
            longestIncreasingSubindex = Math.max(longestIncreasingSubindex, lis[i]);
        }

        return longestIncreasingSubindex;
    }
}
