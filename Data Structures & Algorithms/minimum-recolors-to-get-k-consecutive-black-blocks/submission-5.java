class Solution {
    public int minimumRecolors(String blocks, int k) {
        int minRecolors=k+1;

        int left=0, right=0, recolorsInThisWindow=0;

        while(left<=right && right<blocks.length()) {
            while(right<blocks.length() && right-left+1 <=k) {
                char blockColor = blocks.charAt(right);
                if(blockColor=='W') {
                    recolorsInThisWindow++;
                }
                right++;
            }
            
            minRecolors = Math.min(recolorsInThisWindow, minRecolors);

            char colorToBeRemoved = blocks.charAt(left);
            if(colorToBeRemoved=='W') {
                recolorsInThisWindow--;
            }
            left++;
        }

        return minRecolors;
    }
}