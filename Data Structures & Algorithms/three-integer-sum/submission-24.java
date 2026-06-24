class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>();

        Arrays.sort(nums);//to bring dups next to each other 
        //still don't know how dups are avoided 

        for(int i=0;i<nums.length;i++) {
            int a = nums[i];

            if (i-1 > -1 && a==nums[i-1]) {
                continue;//skip dups 
            }
            
            if(a>0) {
                break;
                //this is because if a is already greater than zero, then
                //the other numbers will be greater than it, so the sum 
                //will never equal zero 
            }

            int left = i+1, right = nums.length-1;



            while(left<right) {
                int threeSum = a + nums[left] + nums[right];
                int leftNum = nums[left];
                    int rightNum = nums[right];
                if (threeSum==0) {
                    triplets.add(Arrays.asList(a, nums[left], nums[right]));
                    while(leftNum==nums[left] && left+1<nums.length) {
                        left++;
                    }

                    while(rightNum==nums[right] && right-1>-1) {
                        right--;
                    }
                } else if (threeSum>0) {
                    while(rightNum==nums[right] && right-1>-1) {
                        right--;
                    }
                } else {
                    while(leftNum==nums[left] && left+1<nums.length) {
                        left++;
                    }
                }
            }
        }

        return triplets;
    }
}
