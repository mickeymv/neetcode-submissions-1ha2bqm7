class Solution {
    public int maxProductDifference(int[] nums) {
        //the max prod diff can be found by finding the 
        //the min prod and the maxProd first 

        //we first sort the array to find the two min elements, and the two max elements 

        Arrays.sort(nums);

        return (nums[nums.length-1]*nums[nums.length-2]) - (nums[0]*nums[1]);
    }
}