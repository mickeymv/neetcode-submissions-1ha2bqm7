class Solution {
    public int[] sortedSquares(int[] nums) {
        List<Integer> squares = new ArrayList<>();

        Stack<Integer> negativeSqaures = new Stack<>();

        //collect squares of negative numbers in a stack 

        int i=0;

        for(; i<nums.length;i++) {
            if(nums[i]>=0) {
                break;//we reached 0/+ve number
            }
            negativeSqaures.push(nums[i]*nums[i]);
        }

        //i will be the index of positive elements going forward 
        for(;i<nums.length;i++) {
            int positiveSquare = nums[i]*nums[i];
            while(!negativeSqaures.isEmpty() && positiveSquare>=negativeSqaures.peek()) {
                squares.add(negativeSqaures.pop());
            }
            squares.add(positiveSquare);
        }

        while(!negativeSqaures.isEmpty()) {
                squares.add(negativeSqaures.pop());
        }

        return squares.stream().mapToInt(Integer::intValue).toArray();
    }
}