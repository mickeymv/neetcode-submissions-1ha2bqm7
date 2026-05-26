class Solution {
    List<List<Integer>> subsets = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        addSubset(0, nums, new ArrayList<>());
        return subsets;
    }

    public void addSubset(int index, int[] nums, List<Integer> subset) {
        if (index>=nums.length) {
            subsets.add(new ArrayList<>(subset));
            return;
        }

        //decision to add the index to the subset 
        subset.add(nums[index]);
        addSubset(index+1, nums, subset);

        //decision to not add the index to the subset 
        subset.remove(subset.size()-1);
        addSubset(index+1, nums, subset);

        return;
    }
}
