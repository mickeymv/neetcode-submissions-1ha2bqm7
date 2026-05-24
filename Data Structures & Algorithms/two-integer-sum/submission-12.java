class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> complementToIndex = new HashMap<>();

        for(int index=0; index<nums.length; index++){
            int num = nums[index];
            int complement = target - num;

            if (complementToIndex.containsKey(complement)) {
                return new int[]{complementToIndex.get(complement), index};
            } else {
                complementToIndex.put(num, index);
            }
        }

        return null;
    }
}
