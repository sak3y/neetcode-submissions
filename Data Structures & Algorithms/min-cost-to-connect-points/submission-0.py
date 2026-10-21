class Solution:
    def minCostConnectPoints(self, points: List[List[int]]) -> int:
        n = len(points)
        adj = {i : [] for i in range(n)} # i : list [cost, node]
        for i in range(n):
            x1, y1 = points[i]
            for j in range(i + 1, n):
                x2, y2 = points[j] 
                dist = abs(x1 - x2) + abs(y1 - y2)
                adj[i].append([dist, j])
                adj[j].append([dist, i])

        res = 0
        visit = set()
        minHeap = [[0, 0]]

        while len(visit) < n:
            cost, i = heapq.heappop(minHeap)
            if i in visit:
                continue
            
            res += cost
            visit.add(i)

            for neiCost, nei in adj[i]:
                if nei not in visit:
                    heapq.heappush(minHeap, [neiCost, nei])
        
        return res


"""
    GOAL: To connect all points, in such a way that we have the minimum distance

    Using mahattan distance between two points

    Brute force:
    - given a point u. 
    - We can connect that to any point?
    - being greedy, we can recursively, form connections that cover all possible combinations
    - TC: O()

    We cna break this down.
    The shortest distance between two points -> easy enough since we do manhattan
    Shorest distance between three points\

    I gues this could be shorest path algo.
    Given an inital points, we can connect it to n - 2 number of points
    We always take the shorest path

    [0,0] : [2,2], [3,3], [2,4], [4,2]
              4      6      6      6    -> sp = 4
    [2,2] : [3,3], [2,4], [4,2]         -> sp = 2
    [3,3] : [2,4], [4,2]                -> sp = 2
    [2,4] : [4,2]                       -> sp = 4
                                        total = 12?

    this aproach has issues because of the overlap.

    Well what if we chose one point rather then chain paths?
    we can get to 10 if we start at point 2,2 since it doesn't involve overlap
    but the questions becomes how does this work for every other point

    Actual solution:
    - Say we are given a point. We cn connect to any number of poitns so we choose the one with the smallest weight.
    - We need a way to keep track of visited nodes so we use a set and avoid cycles
    - 
"""