class Solution:
    def countComponents(self, n: int, edges: List[List[int]]) -> int:
        visit = set()
        
        def dfs(node):
            if node in visit:
                return

            visit.add(node)
            
            for nei in adjList[node]:
                dfs(nei)
        
        adjList = [[] for i in range(n)]
        for u, v in edges:
            adjList[u].append(v)
            adjList[v].append(u)

        res = 0
        for i in range(n):
            if i not in visit:
                dfs(i)
                res+=1

        return res

"""
    For a list, we need to be able to discern sepereate connected graphs/
    Ex. shows two distinct conected subgraphs. 

    How do we tell the number of connected parts?
    Adj list:
        0 : 1,2
        1 : 0,2
        2 : 1
        3 : 4
        4 : 3

    we have n asw. Need a way of storing parts so that once we traverse them, we can add
    them to a list of 'visited' or 'parts' so that way we know what's been covered

    Using the adj list, we can get to the end / complete a single part and add nodes
    as we go along

    then we check to see if we've already visited a node. Skip here
    If we haven't then that indicates a new section.

    BF:
    1. create adj list
    2. peform dfs on adj list for each node
        - Keep track of visited nodes
        - Update count each time we peform a dfs search
        - exhaust until all elements have been covered
        - if we come across a node that hasn't been covered in a dfs then go
    3. return res
"""