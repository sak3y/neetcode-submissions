class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        n = len(board)

        def isRowValid():
            for r in range(n):
                seen = set()
                for c in range(n):
                    cell = board[r][c]
                    if cell == '.':
                        continue
                    if cell in seen:
                        return False
                    
                    seen.add(cell)

            return True
        
        # a cell -> [row][col]
        def isColValid():
            for r in range(n):
                seen = set()
                for c in range(n):
                    cell = board[c][r]
                    if cell == '.':
                        continue
                    if cell in seen:
                        return False
                    
                    seen.add(cell)

            return True

        def isSquare():
            for boxRow in range(0, n, 3):
                for boxCol in range(0, n, 3):
                    seen = set()
                    for r in range(boxRow, boxRow + 3):
                        for c in range(boxCol, boxCol + 3):
                            cell = board[r][c]
                            if cell == '.':
                                continue
                            if cell in seen:
                                return False
                            seen.add(cell)
            return True
            

        return isRowValid() and isColValid() and isSquare()

"""
    3 Rules:
    - Rows cannot contain dupes
    - Cols cannot contain dupes
    - 3x3 sections, broken down in the grid, -> no dupes


    GOAL: We have ot return whether a grid is valid under these
    rules

    '.' represent an emtpy grid, we ignore this

"""