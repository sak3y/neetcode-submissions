class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        ROWS, COLS = len(grid), len(grid[0])
        DIRS = [(1,0), (-1,0), (0,1), (0,-1)]

        def dfs(r, c):
            if (r < 0 or c < 0 
            or r >= ROWS or c >= COLS
            or grid[r][c] == '0'):
                return

            grid[r][c] = '0'
            for dir in DIRS:
                row = r + dir[0]
                col = c + dir[1]

                dfs(row, col)

            return 


        res = 0
        for r in range(ROWS):
            for c in range(COLS):
                if grid[r][c] == '1':
                    dfs(r,c)
                    res+=1
        return res

        

"""
    Island -> is a series of adjacent, connected squares that use '1'
    So if we find a '1' and look at all adjacent squares, 
    connect them, that all becomes 1 island

    And so, the bf approach would be to:
    - find a single 1
    - see how many connected 1s we can make
        - by looking hor and ver
    - then to track that we got that island, 
    - we turn it into 0s
    - how would we do this?
        - recursively, we could explore all possible path ways
        - where 1 exist, convert to 0
        - that gives us the island
        - adn also sensure that we odn't go voer the same island
        - No edges cases to worry about
        - base case is if we reach a 0, we temrinate htat route
    
"""