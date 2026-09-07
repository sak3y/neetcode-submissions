class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        memo = [[-1] * n for _ in range(m)]

        def dfs(x, y):
            if x >= m or y >= n:
                return 0
            if x == (m - 1) and y == (n - 1):
                return 1
            if memo[x][y] != -1:
                return memo[x][y]
            
            memo[x][y] = dfs(x + 1, y) + dfs(x, y + 1)
            return memo[x][y]
        
        return dfs(0, 0)
""" 
    Similar to a graph / dfs problem with recursion
    Start -> top left
    Goal -> bottom right

    Figure out the number of ways to get from start to goal

    Brute force approach
    - take any path -> can only move DOWN or RIGHT at any given time
    - we calcuatle the paths as we go along, the unique combination of those paths we store
    - we only take unique paths
    - so go either right or down. then we get something liek: [right, right down, down]
    - then we count how many unqiue sets of that we have so recursivly

    Implementation
    - we don
"""