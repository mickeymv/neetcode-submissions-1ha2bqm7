class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxK=0, minK;

        for(int pile : piles){
            maxK = Math.max(maxK, pile); //find the largest pile of bananas, 
            //which will give us the upper bound for k 
        }

        int left=1, right= maxK;
        
        minK=maxK;

        while (left<=right) {
            int k = (left+right)/2;

            //check if we can eat the piles in less than h hours 
            //calculate the number of hours it takes to eat all the piles
            long numberOfHoursToEatAtRateK = 0;
            for (int pile : piles) {
                numberOfHoursToEatAtRateK +=  Math.ceil((double)pile/k);
            }

            if (numberOfHoursToEatAtRateK<=h) {
                minK = Math.min(minK, k);
                right = k-1;
            } else {
                //we couldn't finish , increase speed of eating 
                left=k+1;
            }
        }

        return minK;
    }
}
