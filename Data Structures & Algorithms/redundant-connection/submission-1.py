class Solution:
    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
        n = len(edges)
        adj = [[] for _ in range(n + 1)]
        for u, v in edges:
            adj[u].append(v)
            adj[v].append(u)

        visit = [False] * (n + 1)
        cycle = set()
        cycleStart = -1

        def dfs(node, par):
            nonlocal cycleStart
            if visit[node]:
                cycleStart = node
                return True

            visit[node] = True
            for nei in adj[node]:
                if nei == par:
                    continue
                if dfs(nei, node):
                    if cycleStart != -1:
                        cycle.add(node)
                    if node == cycleStart:
                        cycleStart = -1
                    return True
            return False

        dfs(1, -1)

        for u, v in reversed(edges):
            if u in cycle and v in cycle:
                return [u, v]

        return []


"""
    An edge has been added that makes the graph cyclical
    GOAL: Find an edge such that when removed, it stops the graph being cyclical

    If there are mulitiples edges that can be removed, then remove the last one in edges

    Cycle -> if we can return to a node without going back

    I gues we can crate an adjacenty list, which contains a number and a list of edges that it has
    for ex 2:
        1: 2,3,4
        2: 1
        3: 1,4
        4: 1,3,5
        5: 4

        and so, we can detect a cyle by using our adjaceny list. Factoring out two way edges, we say that if we can go through an intermediary, in this case, we can from:
            1 -> 3 -> 4 -> 1: this is the cycle because we got to one without go backwards thru an edge. In other words, we can only use an edge once.

        Recursively, exhaust all possible paths, ex. 1 has three paths we can go down.
        
        So im guessing we keep track of last viisted node so we dont' have something like:
            1 -> 2 -> 1

        Also, sice in a cycle, there are multiple edges we can remove, how do we know the one that is last (the one that needs to eb returned)?

        Steps: BF Solution
        1. Build an adj list
            - traverse pairs in 'edges' and built out a map.
            - adding nodes that don't exist yet and updataing teh values list
        2. Find a cycle
            - Keep track of visited nodes on each iteration
            - Recursively traverse all paths
        3. Decide on which edge to remove
            - given a cycle we can decide on a set of edges to remove

        4. Return that edge


        TC: O(n) + O(n) -> build adj list + find cycle
"""