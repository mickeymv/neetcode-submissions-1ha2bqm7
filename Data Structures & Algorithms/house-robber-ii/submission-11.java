class Solution {
    public int rob(int[] monies) {
        int[] maxRobFromHouseIncludingFirst = new int[monies.length]; //for 3,4,3, this would be [3,4]
        int[] maxRobFromHouseIncludingLast = new int[monies.length]; // for 3,4,3 , this would be [4,3]
        

        maxRobFromHouseIncludingFirst[0]=monies[0];//base case 

        if(monies.length>1) {
            maxRobFromHouseIncludingFirst[1]=Math.max(monies[1],maxRobFromHouseIncludingFirst[0]);
            maxRobFromHouseIncludingLast[1]=monies[1];
            //^base case for the second array because we start at the second house and include 
            //the last house 
        }

        if(monies.length>2) {
            maxRobFromHouseIncludingLast[2]=Math.max(monies[2],maxRobFromHouseIncludingLast[1]);
        }

        for(int house=2;house<monies.length;house++) {
            maxRobFromHouseIncludingFirst[house]=Math.max(monies[house]+maxRobFromHouseIncludingFirst[house-2],maxRobFromHouseIncludingFirst[house-1]);
            maxRobFromHouseIncludingLast[house]=Math.max(monies[house]+maxRobFromHouseIncludingLast[house-2],maxRobFromHouseIncludingLast[house-1]);
        }

        return Math.max(monies.length==1? maxRobFromHouseIncludingFirst[monies.length-1]: maxRobFromHouseIncludingFirst[monies.length-2],
                        maxRobFromHouseIncludingLast[monies.length-1]);

    }
}
