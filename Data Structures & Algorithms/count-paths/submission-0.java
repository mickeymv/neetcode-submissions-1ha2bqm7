class Solution {
    public int uniquePaths(int m, int n) {
        int[][] uniquePathsToEndFromIndex = new int[m][n];

        //base case the last cell is 1
        uniquePathsToEndFromIndex[m-1][n-1]=1;

        //the last row and column will also be 1s 
        //fill last row 
        Arrays.fill(uniquePathsToEndFromIndex[m-1], 1);

        //fill last column 
        for (int row = 0; row<m; row++) {
            uniquePathsToEndFromIndex[row][n-1] = 1;
        }

        //for every cell, fill it by looking at the right and the down cell 

        for (int row=m-2; row>=0; row--) {
            for (int col= n-2; col>=0; col--) {
                uniquePathsToEndFromIndex[row][col] = 
                uniquePathsToEndFromIndex[row+1][col] +
                uniquePathsToEndFromIndex[row][col+1];
            }
        }

        return uniquePathsToEndFromIndex[0][0];
    }


}
