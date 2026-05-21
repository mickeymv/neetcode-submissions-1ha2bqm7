class Solution {
    int[][] uniquePaths;

    public int uniquePaths(int m, int n) {
        uniquePaths = new int[m+1][n+1];
        return uniquePaths(0,0,m,n);
    }

    public int uniquePaths(int row, int col, int m, int n) {
        if (uniquePaths[row][col]!=0) {
            return uniquePaths[row][col];
        }
        //base case, positive, at the final cell 
        if (row == m-1 && col == n-1) {
            return 1;
        }

        //negative base cases, when cells are out of bounds 
        if (row>=m || col >=n) {
            return 0;
        }

        //recurse down and right to find the solution 
        uniquePaths[row+1][col] = uniquePaths(row+1,col,m,n);
        uniquePaths[row][col+1] = uniquePaths(row,col+1,m,n);

        return uniquePaths[row+1][col] + uniquePaths[row][col+1];
    }

}
