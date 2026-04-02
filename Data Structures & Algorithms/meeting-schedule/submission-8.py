"""
Definition of Interval:
class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end
"""

class Solution:
    def canAttendMeetings(self, intervals: List[Interval]) -> bool:
        if len(intervals) <= 1:
            return True;
        
        for i in range(len(intervals)):
            first = intervals[i];
            for j in range(i+1, len(intervals)):
                second = intervals[j];
                if min(first.end, second.end) > max(second.start, first.start):
                    return False;
        
        return True;