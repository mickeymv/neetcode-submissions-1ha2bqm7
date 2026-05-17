class Solution {

    List<List<Integer>> combinationSums;

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        combinationSums = new ArrayList<>();
        checkCombination(0, nums, new ArrayList<>(), target);
        return combinationSums;
    }

    public void checkCombination(int indexOfNum, int[] nums, List<Integer> currNums, int target) {
        //positive case, the current numbers in the list add up to the target
        if (target == 0) {
            combinationSums.add(new ArrayList<>(currNums));
            return;
        }
        
        //base case 
        if (indexOfNum >= nums.length || target < 0) {
            return;
        }

        //we haven't reached the end of the list, nor has the sum been reached. 
        //add the current indexed number to the list and explore that decision tree 
        currNums.add(nums[indexOfNum]);
        checkCombination(indexOfNum, nums, currNums, target-nums[indexOfNum]);

        //remove the current indexed number to the list, and explore the decision tree without that number 
        currNums.remove(currNums.size()-1);
        checkCombination(indexOfNum+1, nums, currNums, target);
    }
}
