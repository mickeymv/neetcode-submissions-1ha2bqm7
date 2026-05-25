class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length-1;
        HashSet<Integer> ints = new HashSet<>();

        for (int num : nums) {
            if (ints.contains(num)) {
                return num;
            } else {
                ints.add(num);
            }
        }

        return 0;
    }
}
