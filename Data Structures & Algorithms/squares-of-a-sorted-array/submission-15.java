class Solution {
    public int[] sortedSquares(int[] nums) {
        int left=0,right=nums.length-1;

        List<Integer> squares = new ArrayList<>();

        while(left<=right) {
            int leftNum = nums[left];
            int rightNum = nums[right];

            if(Math.abs(rightNum)>Math.abs(leftNum)) {
                squares.add(rightNum*rightNum);
                right--;
            } else {
                squares.add(leftNum*leftNum);
                left++;
            }
        }

        Collections.reverse(squares);

        return squares.stream().mapToInt(i->i).toArray();
    }
}