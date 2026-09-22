class Solution:
    def minInterval(self, intervals: List[List[int]], queries: List[int]) -> List[int]:
        intervals.sort()

        minHeap = []
        res, i = {}, 0

        for q in sorted(queries):
            while i < len(intervals) and q >= intervals[i][0]:
                l, r = intervals[i]
                heapq.heappush(minHeap, (r - l + 1, r))
                i += 1

            while minHeap and q > minHeap[0][1]: # q is greater than end value
                heapq.heappop(minHeap)
            res[q] = minHeap[0][0] if minHeap else -1
        return [res[q] for q in queries]

        

        # output = []
        # for q in queries:
        #     length = -1
        #     smallest = float('inf')

        #     for pair in intervals:
        #         if q >= pair[0] and q <= pair[1]:
        #             length = pair[1] - pair[0] + 1
        #             smallest = min(smallest, length)

        #     output.append(smallest if smallest != float('inf') else -1)
        
        # return output
          

"""
Understanding
We're given a list of pairs (intervals) and these have ranges (inclusive)
We're also given a list of queries

----- GOAL: is to see where queries exist in all pairs and find the one wiht the SMALLEST range
Otherwise, return -1 --------

Output[j] must match query[j] so sorting would be tricky

Brute force:
- then we check if our query exists within a pair. We take it's range (start < val < end)
- We then check the next val, and then compare ti to our current range. If it's smaller we take that pair
    otherwise we ignore 
    -> we then go through all of intervals
    -> at which we point we have our smallest val
- move on to the next val and so on
- TC: o(n * m)
- Too slow, we need an optimised solution. whih is O(nlogn + mlogm)

WHY it's too slow right now
- Lot of wasted time comparing on pairs we don't need to look at
- not searching optimally

Optimised solutions
- Sort intervals and queries?
- keep track of original index
- once sorted we know that 

"""