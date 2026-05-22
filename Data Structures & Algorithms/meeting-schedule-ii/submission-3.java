/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        List<Integer> starts = new ArrayList<>();
        List<Integer> ends = new ArrayList<>();

        for (Interval interval : intervals) {
            starts.add(interval.start);
            ends.add(interval.end);
        }    

        starts.sort(Comparator.comparingInt(start -> start));
        ends.sort(Comparator.comparingInt(end->end));

        int maxMeetingRooms = 0;
        int currentMeetingsInProgress = 0;

        int startIndex = 0;
        int endIndex = 0;

        while (startIndex < intervals.size()) {
            int start = starts.get(startIndex);
            int end = ends.get(endIndex);

            if (start<end) {
                //a meeting just started 
                currentMeetingsInProgress++;
                startIndex++;
            } else {
                //a meeting just ended 
                currentMeetingsInProgress--;
                endIndex++;
            }
            maxMeetingRooms = Math.max(maxMeetingRooms, currentMeetingsInProgress);
        }

        return maxMeetingRooms;
    }
}
