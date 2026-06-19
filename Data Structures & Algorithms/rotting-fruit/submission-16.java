class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new ArrayDeque<>();

        int freshFruitRemaining = 0;

        for(int r=0;r<grid.length;r++) {
            for(int c=0;c<grid[0].length;c++) {
                if (grid[r][c]==2) {
                    q.add(new int[]{r,c});
                }
                if (grid[r][c]==1) {
                    freshFruitRemaining++;
                }
            }
        }

        int minutesPassed=0;

        while (!q.isEmpty()) {
            int numOfRottenFruits = q.size();

            for(int i=0;i<numOfRottenFruits;i++) {
                int[] rottenFruitCell = q.poll();
                //out of bounds 
                int r = rottenFruitCell[0], c= rottenFruitCell[1];
                if (r<0||c<0||r>=grid.length||c>=grid[0].length||grid[r][c]==0) {
                    continue;
                }
                //add adjacent fresh fruit cells to the q to be rotten in next pass 


                if (r+1<grid.length && grid[r+1][c]==1) {
                    q.add(new int[]{r+1,c});
                    grid[r+1][c] = 2;//mark as empty so we don't visit it again 
                    freshFruitRemaining--;
                }

                if (c+1<grid[0].length && grid[r][c+1]==1) {
                    q.add(new int[]{r,c+1});
                    grid[r][c+1] = 2;//mark as empty so we don't visit it again 
                    freshFruitRemaining--;
                }

                if (c-1>=0 && grid[r][c-1]==1) {
                    q.add(new int[]{r,c-1});
                    grid[r][c-1] = 2;//mark as empty so we don't visit it again 
                    freshFruitRemaining--;
                }

                if (r-1>=0 && grid[r-1][c]==1) {
                    q.add(new int[]{r-1,c});
                    grid[r-1][c] = 2;//mark as empty so we don't visit it again 
                    freshFruitRemaining--;
                }
            }

            if(!q.isEmpty()) {
                minutesPassed++;
            }
        }

        //rot has processed, check if there is any fresh fruit left 

        if(freshFruitRemaining>0){
            return -1;
        }

        return minutesPassed;
    }
}
