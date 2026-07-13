class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int columns = matrix[0].length; // assumes matrix is non empty
        
        int top = 0;
        int bottom = rows - 1;

        // Part 1: Finding the row target is in
        while (top <= bottom) {
            int row = (top + bottom) / 2;

            // Observe left and right of row to see if target exists between
            if (target > matrix[row][columns - 1]) {
                top = row + 1;
            }
            else if (target < matrix[row][0]) {
                bottom = row - 1;
            }
            else {
                break;
            }
        }

        if (!(top <= bottom)) return false;

        // Part 2: Finding the column the target is in
        int l = 0;
        int r = columns - 1;

        int row = (top + bottom) / 2;

        while (l <= r) {
            int m = (l + r) / 2; // Midpoint

            // If target is less than m, it should be on the left side
            if (target < matrix[row][m]) {
                r = m - 1;
            }
            else if (target > matrix[row][m]) {
                l = m + 1;
            }
            else {
                return true;
            }
        }
        return false;
    }
}

/*
    INTUITON
    - There are two parts to this array.
    - First off, How do we know which row our target is in.
    - Given that the rows are ordered and that each row after contains values that are always
    greater than that off the previous row
    - We can essentialty treat it as one long array
    - As such, given the example. We look at the middle row. Lets say we are looking for the 
    number 2. We evaluate the first index (10) and last index  (13). Target doesn't lie betweeen
    either of these values => won't waste time searching. We know that since 2 < 10. We elimate all rows that come after
    row 2. Then we index down, evaluating row 1. We see that our first index is 1, last is 8. So our values is
    within that range. 
    - Perfrom binary search. So starting at (l + r) / 2 => 1 => which is where 2 is and we return true
*/