class Solution:
    def islandPerimeter(self, grid: List[List[int]]) -> int:
        ROWS, COLS = len(grid), len(grid[0])
        DIRS = [(1, 0), (-1, 0), (0, 1), (0, -1)]

        seen = set()
        def dfs(r, c):
            if r < 0 or c < 0 or r >= ROWS or c >= COLS:
                return 1

            if grid[r][c] == 0:
                return 1
            
            if (r, c) in seen:
                return 0

            seen.add((r, c))

            perimeter = 0
            for dr, dc in DIRS:
                perimeter += dfs(r + dr, c + dc)

            return perimeter
            
        
        for r in range(ROWS):
            for c in range(COLS):
                if grid[r][c] == 1:
                    return dfs(r, c)

