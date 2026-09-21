"""
Definition of Interval:
class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end
"""

class Solution:
    def minMeetingRooms(self, intervals: List[Interval]) -> int:
        start = sorted(i.start for i in intervals)
        end = sorted(i.end for i in intervals)

        rooms, maxRooms = 0, 0
        s, e = 0, 0

        while s < len(intervals):
            if start[s] < end[e]: # overlap
                s += 1
                rooms += 1

            
            else: 
                e += 1
                rooms -= 1

            maxRooms = max(maxRooms, rooms)

        return maxRooms
"""
    Actual solution:
    - we know that for to have a meeting, we need an exisitng one to finihs
    - we keep track of the start time and end time of a meeting
    - 

    rooms: List[List[interval]]

    If we imagine that all the meeting are taking place in a single room
    It may be the case taht some meetings overlap
    In which we would need to create another room for it

    We move the overlapping interval to antoerh room but do we do that greedily?
    in the sense that we can make an intelligent move about where to move an overlapping meeting

    -> it doesn't actually matter because we would check the other rooms availabilities before
    we add a meeting

    we can't just create a new room for every overlapping meeting

    1. find the overlap.
    2. create a new room if one doesn't exist
    3. place (ANY) of the overlapping meeting into that room
    4. if more than 1 room exist, we check if we can slot it into an exisitng room -> we do that
        by comparing the end value with the start value.
        - do that for every room

    TC: O(n) + O(nlogn) + O(m)
"""