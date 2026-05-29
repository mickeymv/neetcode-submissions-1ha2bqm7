class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int left = 0;
        int right = matrix[0].length - 1;
        int bottom = matrix.length - 1;
        int top = 0;

        List<Integer> nums = new ArrayList<>();

        while(left<=right && top<=bottom) {
            //go left
            for(int col=left;col<=right;col++) {
                nums.add(matrix[top][col]);
            }
            top++;

            //go down 
            for (int row=top; row<=bottom; row++) {
                nums.add(matrix[row][right]);
            }
            right--;

            //check invariants are still okay 
            if (!(left<=right && top<=bottom)) {
                break;
            }

            //go left 
            for(int col=right;col>=left;col--) {
                nums.add(matrix[bottom][col]);
            }
            bottom--;

            //go up 
            for (int row=bottom; row>=top; row--) {
                nums.add(matrix[row][left]);
            }
            left++;
        }

        return nums;
    }
}
