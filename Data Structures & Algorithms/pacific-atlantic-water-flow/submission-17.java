class Solution {

    int ROWS, COLS;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        //we can have two boolean grids pacific and atlantic 
        //pacific grid can tell us if a cell's water can flow to pacific 
        //and atlantic's will tell us if a cell's water can flow to the atlantic 

        //the top row and left col of pacific will be true to start , as 
        //well as the right col and bottom row of the atlantic 

        //for every cell, we check if the neighboring cell can reach the pacific/atlantic 
        //if it can, and if the current cell has height higher than or equal to the neighboring cell 
        //, we mark that cell as reachable too (true). 

        //at the end , we check if the cells are reachable in both pacific and atlantic grids 
        //and if so, add to the list. 

        ROWS = heights.length;
        COLS = heights[0].length;

        boolean[][] pacific = new boolean[ROWS][COLS]; 
        boolean[][] atlantic = new boolean[ROWS][COLS]; 

        //mark pacific edges as true to reach pacific 
        for(int r=0;r<ROWS;r++) {
            markReachable(r,0,pacific,heights);
        }

        for(int c=0;c<COLS;c++) {
            markReachable(0,c,pacific,heights);
        }

        //mark atlantic edges as true to reach pacific 
        for(int r=0;r<ROWS;r++) {
            markReachable(r,COLS-1,atlantic,heights);
        }

        for(int c=0;c<COLS;c++) {
            markReachable(ROWS-1,c,atlantic,heights);
        }

        List<List<Integer>> cellsReachable = new ArrayList<>();

        for(int r=0;r<ROWS;r++) {
            for (int c=0;c<COLS;c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    cellsReachable.add(List.of(r,c));
                }
            }
        }

        return cellsReachable;

    }

    public void markReachable(int r, int c, boolean[][] isReachable, int[][] heights){
        isReachable[r][c]=true;

        int nr = r+1, nc=c;

        if(nr>=0 && nr<ROWS
            && nc>=0 && nc<COLS 
            && !isReachable[nr][nc]
            && heights[nr][nc]>=heights[r][c]) {
                markReachable(nr,nc,isReachable,heights);
        }

        nr = r;
        nc=c+1;

        if(nr>=0 && nr<ROWS
            && nc>=0 && nc<COLS 
            && !isReachable[nr][nc]
            && heights[nr][nc]>=heights[r][c]) {
                markReachable(nr,nc,isReachable,heights);
        }

        nr = r-1;
        nc=c;

        if(nr>=0 && nr<ROWS
            && nc>=0 && nc<COLS 
            && !isReachable[nr][nc]
            && heights[nr][nc]>=heights[r][c]) {
                markReachable(nr,nc,isReachable,heights);
        }

        nr = r;
         nc=c-1;

        if(nr>=0 && nr<ROWS
            && nc>=0 && nc<COLS 
            && !isReachable[nr][nc]
            && heights[nr][nc]>=heights[r][c]) {
                markReachable(nr,nc,isReachable,heights);
        }
    }
}
