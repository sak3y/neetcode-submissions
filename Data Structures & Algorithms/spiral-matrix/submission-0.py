class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        res = []
        top, bottom = 0, len(matrix) - 1
        left, right = 0, len(matrix[0]) - 1

        startx, starty = 0, 0
        x, y = 0, 0

        while top <= bottom and left <= right:
            # traverse top row, left to right
            for col in range(left, right + 1):
                res.append(matrix[top][col])
            top += 1

            # traverse right column, top to bottom
            for row in range(top, bottom + 1):
                res.append(matrix[row][right])
            right -= 1

            # traverse bottom row, right to left, only if still valid
            if top <= bottom:
                for col in range(right, left - 1, -1):
                    res.append(matrix[bottom][col])
                bottom -= 1

            # traverse left column, bottom to top, only if still valid
            if left <= right:
                for row in range(bottom, top - 1, -1):
                    res.append(matrix[row][left])
                left += 1

        return res


"""
    spiral ->
    starting from top left
    depending on the side, we take add the numbers in a row /column
    Ex. top row, we move right
    
    Mapping this out: for m = 3, n = 3
    [0][0] -> [1][0] -> [2][0] -> [2][1] -> [2][2] -> [1][2] -> [0][2] > [0][1] 
                                             ^  ^

    Few things:
    - we can't map back onto a value we have just visited
    - also when we reach out of bounds, for x, we trave y. 
    - when x and y both are at the limit, we start decreasing
    - so initialy the range of values we travel are [0][m] and [0][n]
        but on the next iter, it's [0 + 1][m - 1] and [0 + 1][n - 1]

    - how do we consider even and odd matrices too?
    - condition to end the loop -> since we traverse all possible cells, then the total iterations is m * n

    Solution
    - at [0, 0]
    - increase x till max
    - increase y till max
    - once both max, n = n - 1, m = m - 1 and start index + 1 for x, y
    - decrement x
    - decrement y
    - repeat

"""