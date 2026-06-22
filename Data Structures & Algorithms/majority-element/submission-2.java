class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length/2;

        HashMap<Integer, Integer> numToCount = new HashMap<>();

        for(int num:nums){
            numToCount.put(num, numToCount.getOrDefault(num, 0)+1);
            if(numToCount.get(num)>n){
                return num;
            }
        }

        return nums[0];
    }
}