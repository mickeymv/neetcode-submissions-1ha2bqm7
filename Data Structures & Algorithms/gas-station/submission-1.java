class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for(int i=0;i<gas.length;i++) {
            if(canCompleteCircuit(gas, cost, i)) {
                return i;
            }
        }

        return -1;
    }

    public boolean canCompleteCircuit(int[] gas, int[] cost, int startingStation) {
        int gasInCar = 0;
        gasInCar = gas[startingStation];
        if (gasInCar>=cost[startingStation]) {
            return canCompleteCircuit(gas, cost, startingStation,
                                        (startingStation+1)%gas.length, gasInCar-cost[startingStation]);
        } else {
            return false;
        }
    }

    public boolean canCompleteCircuit(int[] gas, int[] cost, int startingStation,
                                        int currentStation, int gasInCar) {
        if (currentStation == startingStation) {
            return true;
        }
        gasInCar+=gas[currentStation];
        if (gasInCar>=cost[currentStation]) {
            return canCompleteCircuit(gas, cost, startingStation,
                                        (currentStation+1)%gas.length, gasInCar-cost[currentStation]);
        } else {
            return false;
        }
    }
}
