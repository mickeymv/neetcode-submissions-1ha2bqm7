class Solution {

    boolean[][] isPartOfIsland;

    public int numIslands(char[][] grid) {
        int numOfIslands = 0;

        isPartOfIsland = new boolean[grid.length][grid[0].length];

        for (int row=0; row<grid.length; row++) {
            for (int col=0; col<grid[0].length; col++) {
                if (grid[row][col] == '1') {
                    if (!isPartOfIsland[row][col]) {
                        numOfIslands++;
                        markAsIsland(row, col, grid);
                    }
                }
            }
        }

        return numOfIslands;
    }

    public void markAsIsland(int row, int col, char[][] grid) {
        if (row>=grid.length || col >= grid[0].length || row<0 || col<0) {
            return;//out of bounds, so it is water
        }
        if (grid[row][col] == '1' && !isPartOfIsland[row][col]) {
            isPartOfIsland[row][col] = true; //mark as an island 
            //check adj lands vertically and horizontally and mark as same island 
            markAsIsland(row+1, col, grid);
            markAsIsland(row-1, col, grid);
            markAsIsland(row, col+1, grid);
            markAsIsland(row, col-1, grid);
        } else {
            return;
        }
    }
}
