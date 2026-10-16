class Solution:
    def pacificAtlantic(self, heights: List[List[int]]) -> List[List[int]]:
        def dfs(r, c, visit, oceans):
            if (r < 0 or c < 0
            or r >= ROWS or c >= COLS
            or (r,c) in visit):
                return 

            visit.add((r,c))

            if r == 0 or c == 0:
                oceans.add("pac")

            if r == ROWS - 1 or c == COLS - 1:
                oceans.add("atl")

            for dr, dc in DIRS:
                row = r + dr
                col = c + dc

                if (0 <= row < ROWS 
                and 0 <= col < COLS
                    and heights[row][col] <= heights[r][c]):
                    dfs(row, col, visit, oceans)
                

            return

        
        ROWS, COLS = len(heights), len(heights[0])
        DIRS = [(1,0), (-1,0), (0,1), (0,-1)]

        res = []

        for r in range(ROWS):
            for c in range(COLS):
                visit = set()
                oceans = set()

                dfs(r, c, visit, oceans)

                if "pac" in oceans and "atl" in oceans:
                    res.append([r,c])

        return res


"""
    At any position (r,c), if we were to put water there, 
    it should be able to reach both atl and pac

    Water can only flow to heights that are either:
    - Equal to or Lower than it
    
    BF:
        So for any given square:
        - How do we reach the top and left borders
        - Also reach the bottom and right border

        - We can intialise a var Pac and set all those rows so that when we reach it, we can say pac reached
        - Do the same thing for atl.
        - We can run dfs to see if both condition are met and hten add to our res
            -base case: going out of bounds, reaching 

    - Antoher perspective is to break the square into three parts:
    - consider the edges as pac xor atl reached
    - and then middle squares that haven't reach any
    - we can hadnles these cases seperatly



    EC: 
    - We know the top right and bottom left will always be part of the solution


"""