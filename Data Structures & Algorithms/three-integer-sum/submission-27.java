class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> triplets = new ArrayList<>();

        for(int i=0;i<nums.length;i++) {
            int outerNum = nums[i];

            if (outerNum>0) {
                break;//zero sum is not possible after sorting 
            }

            if (i>0 && nums[i-1]==outerNum) {
                continue;//skip dups
            }

            int left = i+1, right = nums.length-1;
            
            while(left<right) {

                int leftNum = nums[left];
                int rightNum = nums[right];

                int threeSum = outerNum+leftNum+rightNum;

                if (threeSum>0) {
                    right--;
                } else if (threeSum<0){
                    left++;
                } else {
                    triplets.add(Arrays.asList(outerNum,leftNum,rightNum));
                    right--;
                    left++;
                    while(left<right && nums[left]==nums[left-1]) {
                        left++;
                    }
                }

            }
        }

        return triplets;
    }
}
