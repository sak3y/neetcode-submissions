class Solution:
    def longestIncreasingPath(self, matrix: List[List[int]]) -> int:
        dir = [(0,1), (0,-1), (1,0), (-1,0)]
        ROWS, COLS = len(matrix), len(matrix[0])

        memo = {}

        def dfs(r, c):
            if (r, c) in memo:
                return memo[(r, c)]

            res = 1
            for d in dir:
                nr, nc = r + d[0], c + d[1]

                if 0 <= nr < ROWS and 0 <= nc < COLS and matrix[r][c] < matrix[nr][nc]:
                    res = max(res, 1 + dfs(nr, nc))
                    
            memo[(r, c)] = res
            return res

        longest = 0
        for r in range(ROWS):
            for c in range(COLS):
                longest = max(longest, dfs(r, c))

        return longest

                
"""
    we essentiatly have any starting point (the lower the better)
    we look to neighbours, and see if there is a value greater
    then we can move, do that for all directions

    recursive dfs with memo

    Implementation
    - start
    - Check if directions have values greater
    - if so we can add 1
    - we then keep track of visited values
    - reapeat
"""