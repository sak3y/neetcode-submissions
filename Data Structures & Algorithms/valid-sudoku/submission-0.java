class Solution {
    public boolean isValidSudoku(char[][] board) {
        return (isRowValid(board) && isColumnValid(board) && isGridValid(board));
    }

    public boolean isRowValid(char[][] board) {
        for (int r = 0; r < 9; r++) {
            Set<Character> set = new HashSet<>();

            for (int c = 0; c < 9; c++) {
                char val = board[r][c];
                if (val == '.')
                    continue;
                if (!set.add(val))
                    return false;
            }
        }
        return true;
    }

    public boolean isColumnValid(char[][] board) {
        for (int r = 0; r < 9; r++) {
            Set<Character> set = new HashSet<>();

            for (int c = 0; c < 9; c++) {
                char val = board[c][r];
                if (val == '.')
                    continue;
                if (!set.add(val))
                    return false;
            }
        }
        return true;
    }

    public boolean isGridValid(char[][] board) {
        for (int br = 0; br < 9; br += 3) {
            for (int bc = 0; bc < 9; bc += 3) {
                Set<Character> set = new HashSet<>();

                for (int r = br; r < br + 3; r++) {
                    for (int c = bc; c < bc + 3; c++) {
                        char val = board[r][c];
                        if (val == '.')
                            continue;
                        if (!set.add(val))
                            return false;
                    }
                }
            }
        }
        return true;
    }
}

/*
    Intution:
    - validating sudoku boards -> looking at each row, column and 3x3 square.
    - Input -> 2d array
    - Checking duplicates in an array -> create a map and see that values of index aren't greater
   than 1.
    - Rows: evaluate the values of each array in the big array -> if duplicates return false
    - Columns: evaluate the index at each array so index 1 of array and index 1 of array 2
    - 3x3 Sqaure: create a map of 3 indexes of arrays 1 - 3
    - We're looking for one case of duplicates and that's it we can exit and reutrn false


    Edge Cases:
*/