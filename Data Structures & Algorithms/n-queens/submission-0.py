class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        cols = set()
        posDia = set()
        negDia = set()

        res = []
        board = [['.'] * n for i in range(n)]

        def backtrack(r):
            if r == n:
                copy = ["".join(row) for row in board]
                res.append(copy)
                return

            for c in range(n):
                if c in cols or (r+c) in posDia or (r-c) in negDia:
                    continue

                cols.add(c)
                posDia.add(r+c)
                negDia.add(r-c)
                board[r][c] = 'Q'

                backtrack(r + 1)

                cols.remove(c)
                posDia.remove(r+c)
                negDia.remove(r-c)
                board[r][c] = '.'

        backtrack(0)
        return res


"""
    N -> Size of board AND number of queens

    RULES:
    - Queens cannot be horizontal, vertical or diagonal to another queen

    GOAL:
    - Return the layout of queens that can be placed
    - '.' for empty
    - 'Q' for queen

    So without hindsight:
    - placing the 1st queen, it can be on any square.
    - Therefore, we use a greedy approach to placing queens, and see if subsaquent queens can be placed
    - When placing a queen, we know that the hoz, vert and dia squares are locked off
    - we need a way to keep track fo that so we can use a true/false board | are we doing that for each piece?
    - we then palc ethe queen on the enxt available square.
    - Repeat, following rules
    - If we can place all four then we have a solution. 
    - If we go out of bounds, or there are no remaing squares then we have to repeat from teh 1st queen 
    - Essentiatly recursivelyt placed first queen and subsaquents queens utnil all square have been covered


"""