class Solution {
    public boolean isValidSudoku(char[][] board) {
HashSet<Character>[] rows = new HashSet[9];
HashSet<Character>[] cols = new HashSet[9];
HashSet<Character>[] boxes = new HashSet[9];

        // Initialize each HashSet to avoid npe
for (int i = 0; i < 9; i++) {
    rows[i] = new HashSet<>();
    cols[i] = new HashSet<>();
    boxes[i] = new HashSet<>();
}
        

        for (int r = 0; r < 9; r++) {
           for (int c = 0; c < 9; c++) {
                char cell = board[r][c];
                if (cell == '.') {
                    continue;  // skip empty cells
                }
        // Check if this digit already exists in:
        // - row r
        // - column c
        // - the 3x3 box containing (r, c)
        int boxIndex = (r/3) * 3 + (c/3);

        if (rows[r].contains(cell)) {
            return false;
        } else {
            rows[r].add(cell);
        }

        if (cols[c].contains(cell)) {
            return false;
        } else {
            cols[c].add(cell);
        }

        if (boxes[boxIndex].contains(cell)) {
            return false;
        } else {
            boxes[boxIndex].add(cell);
        }
            }
        }

        return true;
        
    }
}
