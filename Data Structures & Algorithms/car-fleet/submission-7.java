class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        //create a new sorted array of pairs (position, speed) which is 
        //then sorted by speed 
        ArrayList<int[]> cars = new ArrayList<>();

        for (int i=0;i<position.length;i++) {
            cars.add(new int[]{position[i], speed[i]});
        }

        cars.sort(Comparator.comparingInt(car -> car[0]));

        int CARS = position.length;
        Stack<Double> timesTakenToReachTarget = new Stack<>();
        int[] lastCar = cars.get(CARS-1);
        int positionOfLastCar = lastCar[0];
        int distanceForLastCarToTravel = target - positionOfLastCar;
        double timeTakenForLastCarToReachDestination = (double) distanceForLastCarToTravel/lastCar[1];
        timesTakenToReachTarget.push(timeTakenForLastCarToReachDestination);

        for (int carIndex = CARS-2; carIndex>=0; carIndex--) {
            int[] car = cars.get(carIndex);
            int positionOfCar = car[0];
            int distanceForCarToTravelToReachTarget = target - positionOfCar;
            int speedOfCar = car[1];
            double timeTakenForCarToReachTarget = (double) distanceForCarToTravelToReachTarget/speedOfCar;

            double timeTakenForLastCarToReachTarget = timesTakenToReachTarget.peek();

            if (timeTakenForCarToReachTarget<=timeTakenForLastCarToReachTarget) {
                //do nothing, this car will join the last car's fleet
            } else {
                //add this car as a new fleet as it will take more time to reach target 
                timesTakenToReachTarget.push(timeTakenForCarToReachTarget);
            }
        }

        return timesTakenToReachTarget.size();
    }
}
