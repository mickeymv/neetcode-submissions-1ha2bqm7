class Solution {
    List<List<Integer>> combinationSums;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        combinationSums = new ArrayList<>();
        checkCombination(0, new ArrayList<>(), nums, target);
        return combinationSums;
    }

    public void checkCombination(int index, List<Integer> currCombination, int[] nums, int target) {
        //postive case, the sum of all the values in the combination reaches the target 
        if (target == 0) {
            combinationSums.add(new ArrayList(currCombination)); // need to give in a copy of the list since currComb is mutable 
            return;
        }

        //base case, the target exceeded, or we are done with all the elements in the array 
        if (target < 0 || index >= nums.length) {
            return;
        }

        //we make a decision to add the current number to the decision tree 
        currCombination.add(nums[index]);
        checkCombination(index, currCombination, nums, target-nums[index]); //include the curr number again, also reduce target 

        //we make a decision to remove the current number and have combinations without it 
        currCombination.remove(currCombination.size()-1);
        checkCombination(index+1, currCombination, nums, target); //increment index to move past the current number 
    }
}
