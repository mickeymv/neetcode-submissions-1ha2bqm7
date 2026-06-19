class Solution {
    int ROWS, COLS;

    public void solve(char[][] board) {
        ROWS = board.length;
        COLS= board[0].length;

        //top edge 
        for(int c=0;c<COLS;c++) {
            if(board[0][c]=='O'){
                markRegionAsSeen(0,c,board);
            }
        }

        //right edge 
        for(int r=0;r<ROWS;r++) {
            if(board[r][COLS-1]=='O'){
                markRegionAsSeen(r,COLS-1,board);
            }
        }

        //bottom edge 
        for(int c=COLS-1;c>-1;c--) {
            if(board[ROWS-1][c]=='O'){
                markRegionAsSeen(ROWS-1,c,board);
            }
        }

        //left edge 
        for(int r=ROWS-1;r>-1;r--) {
            if(board[r][0]=='O'){
                markRegionAsSeen(r,0,board);
            }
        }

        //after we mark all the border regions as seen, any remaining 'O' regions can be captured 

        for (int r=0;r<ROWS;r++) {
            for(int c=0;c<COLS;c++){
                if(board[r][c]=='O'){
                    markRegionAsCaptured(r,c,board);
                }
            }
        }

        //after we capture all the areas, revert seen back to 'O'

        for (int r=0;r<ROWS;r++) {
            for(int c=0;c<COLS;c++){
                if(board[r][c]=='S'){
                    board[r][c]='O';
                }
            }
        }
    }

    public void markRegionAsSeen(int r, int c, char[][] board) {
        if(r<0||c<0||r>=ROWS||c>=COLS){
           return; 
        }
        if (board[r][c]=='S') {
            return;
        }

            if(board[r][c]=='O'){
                board[r][c]='S';
        //mark neighbors as seen 

                markRegionAsSeen(r+1,c,board);
        markRegionAsSeen(r,c+1,board);
        markRegionAsSeen(r,c-1,board);
        markRegionAsSeen(r-1,c,board);
            }


        

    }

        public void markRegionAsCaptured(int r, int c, char[][] board) {
        if(r<0||c<0||r>=ROWS||c>=COLS){
           return; 
        }
                    if (board[r][c]=='X') {
            return;
        }

            if(board[r][c]=='O'){
                board[r][c]='X';
                //mark neighbors as captured 
        markRegionAsCaptured(r+1,c,board);
        markRegionAsCaptured(r,c+1,board);
        markRegionAsCaptured(r,c-1,board);
        markRegionAsCaptured(r-1,c,board);
            }

        

    }

    
}
