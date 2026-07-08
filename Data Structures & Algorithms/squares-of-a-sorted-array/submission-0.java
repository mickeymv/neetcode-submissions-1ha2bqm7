class Solution {
    public int[] sortedSquares(int[] nums) {
        List<Integer> squares = new ArrayList<>();

        for(int num:nums) {
            squares.add(num*num);
        }

        squares.sort(null);

        return squares.stream().mapToInt(Integer::intValue).toArray();
    }
}