class Solution {
    public int mySqrt(int x) {
        int left=0, right=x;
        
        int mid = (left+right)/2;

        while(left<=right) {
             mid = (left+right)/2;
             long midSquare = (long) mid*mid;
             if(midSquare==x) {
                return mid;
             } else if(midSquare>x) {
                right=mid-1;
             } else {
                left=mid+1;
             }
        }

        /*
        x=8;
        l=0,r=8;
        mid=4;
        16>8

        l=0,r=3;
        mid=1
        1<8
        l=1,r=3;
        mid=2;
        4<8
        l=3,r=4;


        */

        return right;
    }
}