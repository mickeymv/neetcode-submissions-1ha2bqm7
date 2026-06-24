class Solution {
    int ROWS,COLS;
    
    public int numIslands(char[][] grid) {
        ROWS = grid.length;
        COLS=grid[0].length;

        int noOfIslands=0;

        for(int r=0;r<ROWS;r++){
            for(int c=0;c<COLS;c++) {
                if(grid[r][c]=='1'){
                    markIslandAsSeen(r,c,grid);
                    noOfIslands++;
                }
            }
        }

        return noOfIslands;
    }

    public void markIslandAsSeen(int r, int c, char[][] grid) {

        if(r>=ROWS || c>=COLS || r<0 || c<0 || grid[r][c]!='1'){
            return;
        }

        grid[r][c] = '0';

        markIslandAsSeen(r+1,c,grid);
        markIslandAsSeen(r,c+1,grid);
        markIslandAsSeen(r-1,c,grid);
        markIslandAsSeen(r,c-1,grid);
    }
}
