class Solution {
    public int[] sortArrayByParity(int[] nums) {
        List<Integer> evens = new ArrayList<>();
        List<Integer> odds = new ArrayList<>();

        for (int num : nums) {
            if (num%2 == 0) {
                evens.add(num);
            } else {
                odds.add(num);
            }
        }

        evens.addAll(odds);

        return evens.stream()
        .mapToInt(Integer::intValue)
                .toArray();
    }
}