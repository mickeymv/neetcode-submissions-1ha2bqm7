class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(Arrays.stream(gas).sum() < 
            Arrays.stream(cost).sum()){
                return -1;
        }

        //some solution exists

        int startingStation = 0;
        int currentStation=0;
        int gasInTank = 0;

        while(currentStation<gas.length) {
            gasInTank += gas[currentStation];//fill up at this station 

            gasInTank -= cost[currentStation]; //get to next station 

            if (gasInTank<0) {
                //that station won't work, move to next station 
                startingStation = currentStation+1;
                currentStation=startingStation;
                gasInTank=0;
            } else {
                currentStation++;
            }
        }

        return startingStation;
    }
}
