class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] comparisonTriplet = new int[3];


        for(int i=0;i<triplets.length;i++) {
            int[] currentTriplet = triplets[i];
            //check if all the numbers in current triplet is 
            //less than or equal to target triplet 
            if (currentTriplet[0]>target[0]
                ||
                currentTriplet[1]>target[1]
                ||
                currentTriplet[2]>target[2]) {
                    continue;
                    //get the next triplet as this one can't be chosen 
            } 
            comparisonTriplet[0] = Math.max(comparisonTriplet[0], currentTriplet[0]);
            comparisonTriplet[1] = Math.max(comparisonTriplet[1], currentTriplet[1]);
            comparisonTriplet[2] = Math.max(comparisonTriplet[2], currentTriplet[2]);
        }


        for(int i=0;i<3;i++) {
            if(comparisonTriplet[i]!=target[i]){
                return false;
            }
        }

        return true; // comparisonTriplet is equal to target
    }
}
