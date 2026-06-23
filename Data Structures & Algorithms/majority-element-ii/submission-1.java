class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> numToCount = new HashMap<>();

        int n = nums.length/3;

        Set<Integer> majors = new HashSet<>();

        for(int num:nums) {
            int count = numToCount.getOrDefault(num, 0);
            numToCount.put(num, ++count);
            if (count>n) {
                majors.add(num);
            }
        }

        return majors.stream().toList();
    }
}