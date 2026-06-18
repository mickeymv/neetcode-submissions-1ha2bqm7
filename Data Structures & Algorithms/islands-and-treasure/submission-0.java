class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;

        for(int r=0;r<ROWS;r++) {
            for(int c=0;c<COLS;c++){
                if(grid[r][c]==0){
                    //found a treasure chest, update distance of land around it 
                    updateDistance(r+1,c,grid,1);
                    updateDistance(r,c+1,grid,1);
                    updateDistance(r-1,c,grid,1);
                    updateDistance(r,c-1,grid,1);
                }
            }
        }
    }

    public void updateDistance(int r, int c, int[][] grid, int distance) {
        if (r<0||c<0||r>=grid.length||c>=grid[0].length) {
            //out of bounds 
            return;
        }

        int currentDistance = grid[r][c];

        if (currentDistance<distance) {
            return;
        }

        grid[r][c] = distance; //update distance from treasure 

        updateDistance(r+1,c,grid,distance+1);
                    updateDistance(r,c+1,grid,distance+1);
                    updateDistance(r-1,c,grid,distance+1);
                    updateDistance(r,c-1,grid,distance+1);

    }
}
