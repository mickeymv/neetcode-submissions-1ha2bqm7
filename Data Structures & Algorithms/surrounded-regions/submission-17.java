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

        //mark safe regions as land and land as captured
        for(int r=0;r<ROWS;r++) {
            for(int c=0;c<COLS;c++){
                if(board[r][c]=='O'){
                    board[r][c]='X';
                } else if (board[r][c]=='S'){
                    board[r][c]='O';
                } 
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

    
}
