"""
Definition of Interval:
class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end
"""

class Solution:
    def canAttendMeetings(self, intervals: List[Interval]) -> bool:
        intervals.sort(key=lambda i: i.start) # -- can't sort nomrally because it's an object

 
        for i in range(1, len(intervals)):
            if intervals[i - 1].end <= intervals[i].start:
                continue
            
            return False

        return True


"""
    We have a set of intervals.

    GOAL: Find if there is an overlap

    Overlap -> whenever two intervals happen at the same time (non inclusive)

    Brute force solution:
    - sort teh pairs, by starting value
    - Compare each pair with the next
    - if we see that the starting values is less than the end, then we retrun false
    - TC: O(nlogn)

    sorting can't be done here (at least not in a way that I know off)

    so instead. Brute force would have to compare each pair with every other pair in the list
    TC: O(n**2) using a two pointer approach

"""