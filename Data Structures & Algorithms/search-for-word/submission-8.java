class Solution {
    public boolean exist(char[][] board, String word) {
        for (int row = 0; row<board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (wordExists(board, row, col, word, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean wordExists(char[][] board, int curRow, int curCol, String word, int charIndex) {
        //negative conditions, i.e. cell does not exist, or word has exceeded
        if (curRow < 0 || curCol < 0 || curRow >= board.length || curCol >= board[curRow].length || charIndex > word.length()) {
            return false;
        }

        //positive condition, the char matches, advance the charIndex 
        if (board[curRow][curCol] == word.charAt(charIndex)) {
            char ch = word.charAt(charIndex); // save the char for later 
            board[curRow][curCol] = '#'; //mark it so that it is not re-used 
            if (charIndex + 1 == word.length()) { // the entire word was matched 
                return true;
            }
            // check surrounding cells for next char of the word
            //top, down, left, right
            if (wordExists(board, curRow-1, curCol, word, charIndex+1) ||
            wordExists(board, curRow+1, curCol, word, charIndex+1) ||
            wordExists(board, curRow, curCol-1, word, charIndex+1) ||
            wordExists(board, curRow, curCol+1, word, charIndex+1)) {
                return true;
            } else {
                //backtrack and unmark the cell;
                board[curRow][curCol] = ch;
            }
        }

        return false;
    }
}
