class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;

        int topRow=0, bottomRow=ROWS-1;
        
        int targetRow=0;

        while (topRow<=bottomRow) {
            targetRow = (bottomRow+topRow)/2;
            int firstElementOnRow = matrix[targetRow][0];
            int lastElementOnRow = matrix[targetRow][COLS-1];
            if (firstElementOnRow>target) { //target is in earlier rows
                bottomRow = targetRow-1;
            } else if (lastElementOnRow<target){ //target is in later rows
                topRow = targetRow+1;
            } else {
                break; //target is in targetRow
            }
        }

        int leftCol = 0, rightCol=COLS-1;

        int targetCol=0;

        while (leftCol<=rightCol) {
            targetCol = (leftCol+rightCol)/2;
            int numAtIndex = matrix[targetRow][targetCol];
            if (numAtIndex==target) {
                return true;
            } else if (numAtIndex<target) {
                //move right 
                leftCol = targetCol+1;
            } else {
                rightCol = targetCol-1;

            }
        }
        
        return false;
    }

}
