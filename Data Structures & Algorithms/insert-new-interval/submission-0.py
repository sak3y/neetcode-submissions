class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        
        res = []
        i = 0
        n = len(intervals)

        while i < n and intervals[i][1] < newInterval[0]:
            res.append(intervals[i])
            i  += 1

        while i < n and intervals[i][0] <= newInterval[1]:
            newInterval[0] = min(intervals[i][0], newInterval[0])
            newInterval[1] = max(intervals[i][1], newInterval[1])
            i += 1
        
        res.append(newInterval)

        while i < n:
            res.append(intervals[i])
            i += 1

        return res
"""
    We're given newInterval
    Depending on the values, we can either:
    - insert newint into the sorted list
    - connect one OR two intervals if there is an overlap

    Trace:
    - [3,5] and NI: [6,7] -> then we get [[3,5],[6,7]]
    - [3,5] and NI: [5,7] -> then we get [3,7]
    - [[1,2][3,5]] and NI: [2,7] -> then we get [1,7]

    1. We check what sort of operation: insert or merge
    2. Check where that happens,
    inserting -> first val must come after last val of pair but last val must come before
    the first val of a pair 
    3. if we find that any of the values 
    
    So brute force:
    1. we want to find the values that are less than both values in our newint.
    2. those would be added to our list.
    3. when we get to the stage where there is an overlap and the obove condition dont' match
    4. that's when we decide to either merge or insert. 
    5. A merge: evaluate a pair that has overlap in whcih case we take the first values as the min and hte next val as the max between the two. as long as the overlap continues, we then do the same with the next ones
    6. if there was no overlap, we simply add it to our res (newint) and hten add the remaiing values
    7. 
"""