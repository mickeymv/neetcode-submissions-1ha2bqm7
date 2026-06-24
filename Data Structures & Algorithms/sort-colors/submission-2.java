class Solution {
    public void sortColors(int[] nums) {
        int red=0, white=0, blue=0;

        for(int num:nums) {
            if(num==0){
                red++;
            } else if (num==1) {
                white++;
            } else {
                blue++;
            }
        }

        int i=0;

        for(i=0;i<red;i++) {
            nums[i]=0;
        }

        white=i+white;

        for(;i<white;i++) {
            nums[i]=1;
        }

        blue=i+blue;

        for(;i<blue;i++) {
            nums[i]=2;
        }        
    }
}