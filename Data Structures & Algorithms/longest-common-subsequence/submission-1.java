class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] lcs = new int[text1.length()+1][text2.length()+1];

        //we go bottom up
        //we check from the cell m-1,n-1 whether the chars match
        //if they match, we do 1+of cell diag (r+1, c+1)
        //if they don't match we do the max of either the right cell (col+1)
        //or the down cell (row+1). we fill this way until we reach the top-left 
        //cell and return the value in that cell 
        
        for (int row = text1.length()-1; row>=0; row--) {
            for (int col = text2.length()-1; col>=0;col--) {
                if(text1.charAt(row)==text2.charAt(col)) {
                    lcs[row][col] = 1 + lcs[row+1][col+1];
                } else {
                    lcs[row][col] = Math.max(lcs[row+1][col],
                                            lcs[row][col+1]);
                }
            }
        }

        return lcs[0][0];
    }
}
