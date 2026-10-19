class Solution:
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        adjList = {i : [] for i in range(1, n + 1)}
        for u,v,t in times:
            adjList[u].append((v,t)) # [nei, time]

        weights = {i : float('inf') for i in range(1, n + 1)} # track small weights up to each node
        def dfs(node, time):
            if weights[node] <= time:
                return


            weights[node] = time

            for nei, wei in adjList[node]:
                dfs(nei, time + wei)


        dfs(k, 0)
        res = max(weights.values())
        return res if res != float('inf') else -1


"""
    Directed graph: 'times' -> (u, v ,t)
        u -> source node
        v -> end node
        t -> time to get from u to v

    N = number of nodes
    k = starting node

    GOAL: find min time for all nodes to recieve signal
        - Must be able to reach all nodes from k, else return -1

    In the exaple, we can go two ways
    either 1 -> 2, or 1 -> 4. But note that 1 -> 4 doesn't let us visit all nodes, so is not valid

    adj list:
    1 : 2,4
    2 : 3
    3 : 4

    node : [[nei1, time1], [nei2, time2]]


    We need to keep track of visited nodes asw and it must be size n when we finish

    
    - From k, we want to visit all node
    - from 1 -> 2 it costs 1
    - but since there are many paths, we have to exhaust all of them (we don't know in
        advance the best route)
    - so we recursively use dfs
    - for each dfs, we need the time, a visited array, 
    - Traversal, we can use the adjacency list to travel

    Brute force:
    1. Build adj list
    2. build dfs func
    3. For every child of node K, peform dfs
        - Keep track of valid paths
    4. use min to calculate shortest path


"""