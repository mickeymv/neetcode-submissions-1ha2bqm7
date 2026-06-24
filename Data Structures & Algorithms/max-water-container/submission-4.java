class Solution {
    public int maxArea(int[] heights) {
        int left=0, right = heights.length-1;

        int maxArea = 0 ;


        while(left<right) {
            int leftHeight = heights[left], rightHeight = heights[right];
            int usableHeight = Math.min(leftHeight,rightHeight);
            int length = right-left;
            maxArea = Math.max(maxArea, usableHeight*length);

            //keep the maxHeight 
            if(leftHeight<rightHeight) {
                left++;
            } else {
                right--;
            }
        }


        return maxArea;
    }
}
