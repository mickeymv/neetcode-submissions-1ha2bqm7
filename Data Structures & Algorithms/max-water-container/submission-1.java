class Solution {
    public int maxArea(int[] heights) {
        /*
        Volume = distance between two bars * min-height. 
        */

        /*
        Naive solution would be to calculate the volume of every 2 separate bars, and figure out 
        which ones provide the maxArea. Note that for maxArea, we have to use the 
        minimum of the heights of the two bars being considered.
        */

        int maxArea = 0;

        for(int ithBar = 0; ithBar < heights.length-1; ithBar++) {
            for(int jthBar = ithBar+1; jthBar < heights.length; jthBar++) {
                int length = jthBar-ithBar;
                int height = heights[ithBar] < heights[jthBar] ? heights[ithBar] : heights[jthBar];
                int area = length * height;
                maxArea = maxArea > area ? maxArea : area;
        }   
        }
        return maxArea;
    }
}
