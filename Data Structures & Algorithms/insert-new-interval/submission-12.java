class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> finalIntervals = new ArrayList<>();
        int newStart = newInterval[0];
        int newEnd = newInterval[1];

        boolean mergedIntervalAdded = false;

        for (int[] interval : intervals) {
            if(interval[1]<newStart) {
                //interval ends before new interval, add it 
                finalIntervals.add(interval);
                continue;
            }

            if(newEnd<interval[0]) {
                //internal starts after new interval, add it 
                if (!mergedIntervalAdded) {
                    finalIntervals.add(new int[]{newStart, newEnd});
                    mergedIntervalAdded=true;
                }
                finalIntervals.add(interval);
                continue;
            }

            //merge overlapping intervals
            newStart = Math.min(newStart, interval[0]);
            newEnd = Math.max(newEnd, interval[1]);
        }

        if (!mergedIntervalAdded) {
                    finalIntervals.add(new int[]{newStart, newEnd});
        }

        return finalIntervals.toArray(new int[0][]);
    }
}
