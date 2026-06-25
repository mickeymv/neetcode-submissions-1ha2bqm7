class Solution {
    
    int ROWS;
    int COLS;

    Queue<int[]> rottenFruitCells = new LinkedList<int[]>();
        int freshFruitsRemaining=0;


    public int orangesRotting(int[][] grid) {
        //0 - empty 
        //1 - fresh 
        //2 - rotten 

ROWS = grid.length;
COLS = grid[0].length;

        int minutesElapsed = 0;

        //in every minute, a fresh fruit right next to a rotten fruit 
        //gets rotten 
        //so we need to add each rotten fruit cell to a queue, and process it 
        //level by level (minute by minute)


        for(int r=0;r<ROWS;r++){
            for(int c=0;c<COLS;c++) {
                if(grid[r][c]==1) {
                    freshFruitsRemaining++;
                } else if (grid[r][c]==2) {
                    rottenFruitCells.add(new int[]{r,c});
                }
            }
        }

        if (freshFruitsRemaining==0) {
            return freshFruitsRemaining;
        }

        while(!rottenFruitCells.isEmpty() && freshFruitsRemaining>0) {
            minutesElapsed++;
            int rottenFruits = rottenFruitCells.size();
            while(rottenFruits>0 && freshFruitsRemaining>0) {
                rottenFruits--;
                int[] rottenCell = rottenFruitCells.poll();
                int r=rottenCell[0], c = rottenCell[1];
                makeRotten(r+1,c,grid);
                makeRotten(r,c+1,grid);
                makeRotten(r-1,c,grid);
                makeRotten(r,c-1,grid);
            }
        }

        if(rottenFruitCells.isEmpty() && freshFruitsRemaining!=0) {
            return -1; // no more rotten fruits but there are still some fresh fruits
        }

        return minutesElapsed;
    }

    public void makeRotten(int r, int c, int[][] grid) {
        if (r<0 || c<0 || r>=ROWS || c>=COLS) {
            return;//out of bounds
        }
        if (grid[r][c]==0 || grid[r][c]==2) {
            return;//can't make rotten
        }

        if (grid[r][c]==1) {
            grid[r][c]=2;//made rotten
            rottenFruitCells.add(new int[]{r,c});
            freshFruitsRemaining--;
            return;
        }
    }
}
