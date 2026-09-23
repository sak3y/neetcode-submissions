class Solution:
    def setZeroes(self, matrix: List[List[int]]) -> None:
        ROWS, COLS = len(matrix), len(matrix[0])
        markr = [False] * ROWS
        markc = [False] * COLS

        for r in range(ROWS):
            for c in range(COLS):
                if matrix[r][c] == 0:
                    markr[r] = True
                    markc[c] = True

        for r in range(ROWS):
            for c in range(COLS):
                if markr[r] or markc[c]:
                    matrix[r][c] = 0
                

        

        

"""
    Find zero -> matrix traversal (two pointer)
    Greedy approach -> for every row and column in line with our 0, change to 0
    obviosly, we don't want to enter an infinite recursion since once we convert to 0, we need to know if it's
    an originanl and nnot one we put there

    instead we can use a placeholder like -1
    and then once we have traversed all original 0s, convert the -1 -> 0

    1. find 0
    2. change 0 into -1
    3. change row into -1s
    4. change columns into -1s
    5. repeat until we have reached the bottom right
    
    Implementation:
    - wh
"""