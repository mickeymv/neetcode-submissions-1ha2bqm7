class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        Set<Integer> removedOverlappingIntervals = new HashSet<>();
        int noOfRemovedOverlappingIntervals = 0;
        int lastEnd = intervals[0][1];

        for (int i=1; i<intervals.length;i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            //check for overlap 
            if (lastEnd<=start) {
                //no overlap, update lastEnd to the last interval 
                lastEnd = Math.max(lastEnd, end);
            } else { //there is overlap, check which one to remove 
                //we remove the interval with the later end time, so we keep the one with the 
                //earlier endTime 
                lastEnd = Math.min(lastEnd, end);
                noOfRemovedOverlappingIntervals++;
            }
        }

        return noOfRemovedOverlappingIntervals;
    }
}
