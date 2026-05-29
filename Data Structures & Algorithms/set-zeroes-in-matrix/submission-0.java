class Solution {
    public void setZeroes(int[][] matrix) {
        HashSet<Integer> rowsToBeZeroes = new HashSet<>();
        HashSet<Integer> colsToBeZeroes = new HashSet<>();
        for(int row=0;row<matrix.length;row++) {
            for(int col=0;col<matrix[0].length;col++) {
                if(matrix[row][col]==0) {
                    rowsToBeZeroes.add(row);
                    colsToBeZeroes.add(col);
                }
            }
        }

        for(int row=0;row<matrix.length;row++) {
            for(int col=0;col<matrix[0].length;col++) {
                if(rowsToBeZeroes.contains(row) || colsToBeZeroes.contains(col)) {
                    matrix[row][col]=0;
                }
            }
        }
    }
}
