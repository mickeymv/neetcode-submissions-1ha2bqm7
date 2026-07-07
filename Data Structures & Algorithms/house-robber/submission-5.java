class Solution {
    public int rob(int[] monies) {
        int[] maxMoneyToRobFromHousesUntilThisHouse = new int[monies.length];

        maxMoneyToRobFromHousesUntilThisHouse[0] = monies[0];
        //^ the max money that can be robbed from one house is the money in that house 

        if(monies.length>1) {
            maxMoneyToRobFromHousesUntilThisHouse[1] = Math.max(monies[1],
                                                                maxMoneyToRobFromHousesUntilThisHouse[0]);
        }


        for(int house=2;house<monies.length;house++) {
            maxMoneyToRobFromHousesUntilThisHouse[house] = Math.max(maxMoneyToRobFromHousesUntilThisHouse[house-2]+monies[house],
                                                                    maxMoneyToRobFromHousesUntilThisHouse[house-1]);
        }

        return maxMoneyToRobFromHousesUntilThisHouse[monies.length-1];
    }
}
