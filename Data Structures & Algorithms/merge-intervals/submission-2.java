class Solution {
    public int[][] merge(int[][] intervals) {
        
        //sort intervals in place by their start value in ascending order 
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

        List<int[]> nonOverlappingIntervals = new ArrayList<>();

        nonOverlappingIntervals.add(intervals[0]); //add first interval

        int i=1; //iterate from the second interval

        while (i<intervals.length) {
            int[] previousInterval = nonOverlappingIntervals.getLast();
            int[] currentInterval = intervals[i];

            //check if they overlap 

            //no overlap 
            if (previousInterval[1] < currentInterval[0]) {
                //add current interval to the result set 
                nonOverlappingIntervals.add(currentInterval);
            } else {
                //there is overlap, merge previous and current interval 
                nonOverlappingIntervals.removeLast();
                int[] mergedInterval = new int[]{Math.min(previousInterval[0], currentInterval[0]),
                                                    Math.max(previousInterval[1], currentInterval[1])};
                nonOverlappingIntervals.add(mergedInterval);
            }
            i++;
            continue;//to next interval 
        }

        return nonOverlappingIntervals.toArray(new int[0][]);
    }
}
