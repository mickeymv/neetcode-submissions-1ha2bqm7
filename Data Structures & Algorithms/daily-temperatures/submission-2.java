class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] warmerDays = new int[temperatures.length];

        for(int index = 0; index < temperatures.length; index++) {
            int temperature = temperatures[index];
            for(int j=index+1;j<temperatures.length;j++){
                int nextTemperature = temperatures[j];
                if (nextTemperature>temperature) {
                    warmerDays[index] = j-index;
                    break;
                } 
            }
        }

        return warmerDays;
    }
}
