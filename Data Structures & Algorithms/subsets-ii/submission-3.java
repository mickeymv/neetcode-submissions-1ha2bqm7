class Solution {

    List<List<Integer>> subsets = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        //sort the nums so that all the duplicates are next to each other 
        //this means when we choose to include a number, we need to increment the index 
        //to not include a duplicate of that number 

        Arrays.sort(nums);

        addSubset(0, nums, new ArrayList<>());

        return subsets;
    }

    public void addSubset(int index, int[] nums, List<Integer> subset) {
        //base case if there are no more nums to process 
        if (index >= nums.length) {
            subsets.add(new ArrayList<>(subset));
            return;
        }

        //add the element into the subset 

        subset.add(nums[index]);

        addSubset(index+1, nums, subset);

        subset.removeLast();

        while (index<nums.length-1 && nums[index]==nums[index+1]) {
            index++;
        }

        //don't add the element into the subset
        addSubset(index+1, nums, subset);
    }
}
