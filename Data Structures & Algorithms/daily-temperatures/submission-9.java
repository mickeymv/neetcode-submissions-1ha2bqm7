class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] warmerDays = new int[temperatures.length];

        Stack<int[]> stack = new Stack<>();

        stack.push(new int[]{temperatures[0], 0});

        for (int currentDay=1; currentDay < temperatures.length; currentDay++) {
            int currentTemperature = temperatures[currentDay];

            while(!stack.isEmpty()) {
                int[] lastDay = stack.peek();
                int lastTemperature = lastDay[0];

                if (currentTemperature>lastTemperature) {
                    stack.pop();
                    int lastTemperatureDay = lastDay[1];
                    warmerDays[lastTemperatureDay] = currentDay-lastTemperatureDay;
                } else {
                    break;
                }
            }
            stack.push(new int[]{currentTemperature, currentDay});
        }

        return warmerDays;
    }
}
