class Solution {
    public int maxArea(int[] heights) {
        int maxArea = 0;
        int left=0, right = heights.length-1;

        while (left<right) {
            int usableHeight = Math.min(heights[left], heights[right]);
            int length = right-left;
            maxArea = Math.max(maxArea, usableHeight*length);
            if(heights[left]<heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
