class Solution:
    def findItinerary(self, tickets: List[List[str]]) -> List[str]:
        adj = defaultdict(list)

        tickets.sort(reverse=True)
        for u,v in tickets:
            adj[u].append(v)
       
        res = []
        def dfs(src):
            while adj[src]:
                dst = adj[src].pop()
                dfs(dst)
            res.append(src)

        dfs('JFK')
        return res[::-1]


"""
    We start from JFK
    - We need to find the flight path someone took.
    - Input: List of flights [to, from]
    
    GOAL: Reconstruct the path taken, assuming each ticket
    is only used once

    If there are multiple flight paths, we have to return the
    lexicographically smallest one

    - Assume that at least one path is valid

    Directed graph:
    - There is only path

    ex1:
        ADJ:
            JFK: BUF
            BUF: HOU
            HOU: SEA
            SEA: NaN
    ex2:
        ADJ:
            JFK: HOU, SEA
            SEA: JFK

    
    Subproblems:
    1. Build an adj list
    2. Sort destinations lexicographically
        Not sure how
    3. visit destination exhaustilvey (dfs)
    4. cover all destinations / determine a path is valid
        Use a set to track all nodes
    5. handle multiple flight paths
        - can either store and compare 
        - sort then go


   
"""