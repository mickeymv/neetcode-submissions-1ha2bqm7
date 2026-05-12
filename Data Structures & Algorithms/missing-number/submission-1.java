class Solution {
    public int missingNumber(int[] nums) {
        //find the range 
        //range is 0..nums.length
        int rangeMax = nums.length;

        Set<Integer> numbers = new HashSet<>();

        for (int i = 0; i<=rangeMax; i++) {
            numbers.add(i);
        }

        for (int number : nums) {
            numbers.remove(number);
        }

        return numbers.iterator().next();
    }
}
