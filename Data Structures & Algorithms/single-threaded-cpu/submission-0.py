class Solution:
    def getOrder(self, tasks: List[List[int]]) -> List[int]:
        ordered = sorted(
            (enq, pro, i)
            for i, (enq, pro) in enumerate(tasks)
        )

        minHeap = []
        t = 0
        res = []
        i = 0

        while i < len(ordered) or minHeap:
            if not minHeap and i < len(ordered):
                enq = ordered[i][0]
                t = max(t, enq)

            while i < len(ordered) and ordered[i][0] <= t:
                enq, pro, idx = ordered[i]
                heapq.heappush(minHeap, (pro, idx))
                i += 1

            if minHeap:
                pro, idx = heapq.heappop(minHeap)
                res.append(idx)
                t += pro

        return res

"""
    We can process one task at a time
    task: [enqTime, procTime] -> 
        - where enqTime = when it can be processed
        - processTime = how long it takes to process

        [3, 4] -> start at time = 3 and finsishes at time = 7

    how cpu chooses:
    - picks the first available task
    - if multiple tasks have same enqueue time, we pick the one with the smallest processing time
    - if multiples tasks with the smallest proccessing time pick lowest INDEX

    Brute force
    - we have time T which increments by 1
    - Check which enqueue times match T -> we can process these
    - Deciding task processsing order (conflict)
        if only 1 task available at time t -> process
        if tasks > 1:
            (assumption: enqeueu times is irrelevent once multiple tasks become available)
            pick one with shortest processign time
                if multiple:
                    pick smallest index

    so we use a heap.
    keep track of : idx, process time, strt time
    issue : how do we process tasks in this order 
        : valid start time -> smallest prcess time -> smallest index
"""