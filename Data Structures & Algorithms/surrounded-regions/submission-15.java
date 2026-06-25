class Solution {
    
    int ROWS,COLS;
    
    public void solve(char[][] board) {
        ROWS = board.length;
        COLS = board[0].length;


        //mark edge-based regions as non-capturable 'S'
        for(int r=0;r<ROWS;r++) {
            if(board[r][0]=='O') {
                markAsNonCapturable(r,0,board);
            } 
            if(board[r][COLS-1]=='O') {
                markAsNonCapturable(r,COLS-1,board);
            }
        }

        for(int c=0;c<COLS;c++){
            if(board[0][c]=='O') {
                markAsNonCapturable(0,c,board);
            } 
            if(board[ROWS-1][c]=='O') {
                markAsNonCapturable(ROWS-1,c,board);
            }
        }

        //mark non-edge-based regions as captured 'X'
        for(int r=1;r<ROWS-1;r++) {
            for(int c=1;c<COLS-1;c++){
                if(board[r][c]=='O'){
                    markRegionAsCaptured(r,c,board);
                }
            }
        }

        //un-mark edge-based regions as land 
        for(int r=0;r<ROWS;r++) {
            if(board[r][0]=='S') {
                reMarkAsLand(r,0,board);
            } 
            if(board[r][COLS-1]=='S') {
                reMarkAsLand(r,COLS-1,board);
            }
        }

        for(int c=0;c<COLS;c++){
            if(board[0][c]=='S') {
                reMarkAsLand(0,c,board);
            } 
            if(board[ROWS-1][c]=='S') {
                reMarkAsLand(ROWS-1,c,board);
            }
        }
    }

    public void markAsNonCapturable(int r, int c, char[][] board) {
        if(r<0 || c<0 || r>=ROWS || c>=COLS || board[r][c]!='O') {
            return;
        }

        //mark as non-capturable 
        board[r][c]='S';

        //mark neighbors as non-capturable since they are from the edge 
        markAsNonCapturable(r+1,c,board);
        markAsNonCapturable(r,c+1,board);
        markAsNonCapturable(r-1,c,board);
        markAsNonCapturable(r,c-1,board);
    }

    public void markRegionAsCaptured(int r, int c, char[][] board) {
        if(r<0 || c<0 || r>=ROWS || c>=COLS || board[r][c]!='O') {
            return;
        }

        //mark as captured 
        board[r][c]='X';

        //mark neighbors as captured since they are NOT from the edge 
        markRegionAsCaptured(r+1,c,board);
        markRegionAsCaptured(r,c+1,board);
        markRegionAsCaptured(r-1,c,board);
        markRegionAsCaptured(r,c-1,board);
    }

    public void reMarkAsLand(int r, int c, char[][] board) {
        if(r<0 || c<0 || r>=ROWS || c>=COLS || board[r][c]!='S') {
            return;
        }

        //mark as land
        board[r][c]='O';

        //mark neighbors as land since they are from the edge 
        reMarkAsLand(r+1,c,board);
        reMarkAsLand(r,c+1,board);
        reMarkAsLand(r-1,c,board);
        reMarkAsLand(r,c-1,board);
    }
}
