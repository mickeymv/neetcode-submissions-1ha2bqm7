class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int maxUnSatisfiedCustomersInAWindow=0;

        int satisfiedCustomers = 0;
        for(int i=0;i<customers.length;i++) {
            if(grumpy[i]==0) {
                satisfiedCustomers+=customers[i];
            }
        }


        //we can maintain a sliding window of minutes duration, 
        //and then calculate the maxUnSatisfiedCustomersInAWindow in that window 
        

        int left=0, right=minutes-1;
        int unSatisfiedCustomersInAWindow=0;

        //initialize the initial window 
        for(int i=left;i<=right;i++) {
            if(grumpy[i]==1) {
                unSatisfiedCustomersInAWindow+=customers[i];
            }
        }
        
        maxUnSatisfiedCustomersInAWindow = unSatisfiedCustomersInAWindow;


        while(left<=right && right<customers.length-1) {
            //remove left 
            if (grumpy[left]==1) {
                unSatisfiedCustomersInAWindow-=customers[left];
            }

            left++;

            //add right;
            right++;

            if (grumpy[right]==1) {
                unSatisfiedCustomersInAWindow+=customers[right];
            }
            maxUnSatisfiedCustomersInAWindow = Math.max(maxUnSatisfiedCustomersInAWindow, unSatisfiedCustomersInAWindow);
        }

        return satisfiedCustomers+maxUnSatisfiedCustomersInAWindow;

    }
}