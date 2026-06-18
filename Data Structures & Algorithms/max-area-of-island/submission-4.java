class Solution {

    int maxArea = 0;

    public int maxAreaOfIsland(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        
        for (int r=0;r<ROWS;r++) {
            for(int c=0;c<COLS;c++) {
                maxArea = Math.max(maxArea, checkMaxArea(r,c,grid,0));
            }
        }

        return maxArea;
    }

    public int checkMaxArea(int r, int c, int[][] grid, int currMaxArea) {
        if (r>=grid.length || c >= grid[0].length || r<0||c<0) {
            //we are in the water, return
            return currMaxArea;
        }

        if (grid[r][c]<1) {
            //we saw this land previously (don't count again ), or it is water (ignore) 
            return currMaxArea;
        }

        //mark land as seen 
        grid[r][c] = -1;
        currMaxArea++;

        //check neighbors 
        currMaxArea=checkMaxArea(r+1,c,grid,currMaxArea);
        currMaxArea=checkMaxArea(r-1,c,grid,currMaxArea);
        currMaxArea=checkMaxArea(r,c+1,grid,currMaxArea);
        currMaxArea=checkMaxArea(r,c-1,grid,currMaxArea);

        return currMaxArea;
    }
}
