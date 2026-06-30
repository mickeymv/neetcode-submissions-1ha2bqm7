class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] warmer = new int[temperatures.length];

        Arrays.fill(warmer, 0);

        //this stack contains the index of the colder temperatures 
        //this is a monotonically decreasing array of indices of 
        //colder temps 
        Stack<Integer> colderTemps = new Stack<>();

        for(int day=0;day<temperatures.length;day++) {
            int currentTemp = temperatures[day];

            while(!colderTemps.isEmpty() && temperatures[colderTemps.peek()] <currentTemp) {
                int noOfDaysBeforeWarmerTemp = day-colderTemps.peek();
                warmer[colderTemps.peek()] = noOfDaysBeforeWarmerTemp;
                colderTemps.pop();
            }

            colderTemps.push(day);
        }

        return warmer;
    }
}
