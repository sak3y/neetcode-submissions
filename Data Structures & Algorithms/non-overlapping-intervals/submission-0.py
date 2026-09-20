class Solution:
    def eraseOverlapIntervals(self, intervals: List[List[int]]) -> int:
        res = 0
        intervals.sort() # start values first then sort by end value
        prevEnd = intervals[0][1]

        for start, end in intervals[1:]:
            if prevEnd <= start:
                # valid 
                prevEnd = end

            else:
                res += 1
                prevEnd = min(prevEnd, end)
                # remove the longer one
        return res

    


"""
    intervals can overlap as in they can start and end at the same numbers.
    Essentialy we are looking at the non-inclusive digits held withhin the range
    ex: [1,3], for a value to overlap, it would have to contain 2, so [2,3], [0,2],[1, 5]
    - So an overlap also includes both digits falling into anothers inclusive range

    GOAL: minimum nuber of intervals needed to make the list non overlapping

    brute force
    sort
    compare x and x+1 pair
    if overlap remove one of them (we have a choice)
    move to next two values

    [[1,2],[2,4],[1,4],[2,10]]

    -> this doesn't work.
    1. I'ts not optimal, doesn't guarentee to give us the min

    Problems so far. 
    Finding an optimal solution

    Given solution.
    brute force: would be O(2**n), since each interval we can decide to remove or not remove it.

    We can break it down into a series of cases for what an overlap is. Overlap is if start value for a pair is before an end value of another pair
    In this case, we have to remove one of them. The one we remove is the one with the lower end value.
    this way we cover the best case scenraio cause shorter eans less likely to overlap
    Obiously, we would need to drawr this out to better undersatnd why this is true

    so 


"""