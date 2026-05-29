class Solution {
    public double myPow(double x, int n) {
        double product=1;
        if (n>0) { 
            while(n>0) {
                product*=x;
                n--;
            }
            return product;
        } else { //negative n, get the reciprocal
            n=-n;
            while(n>0) {
                product*=x;
                n--;
            }
            return 1/product;
        }

    }
}
