class Solution {
    public boolean isValidSudoku(char[][] board) {
        // check each row
        for (int r = 0; r < board.length; r++) {
            Set<Character> row = new HashSet<>();

            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == '.')
                            continue;
                if (row.contains(board[r][c]))
                    return false;
                row.add(board[r][c]);
            }
        }

        // check each column
        for (int c = 0; c < board[0].length; c++) {
            Set<Character> col = new HashSet<>();

            for (int r = 0; r < board.length; r++) {
                if (board[r][c] == '.')
                            continue;
                if (col.contains(board[r][c]))
                    return false;
                col.add(board[r][c]);
            }
        }

        // Check 3x3, 0->3, 3->6, 6->9
        for (int boxRow = 0; boxRow < 9; boxRow += 3) {
            for (int boxCol = 0; boxCol < 9; boxCol += 3) {
                Set<Character> box = new HashSet<>();
                for (int r = boxRow; r < boxRow + 3; r++) {
                    for (int c = boxCol; c < boxCol + 3; c++) {
                        char val = board[r][c];
                        if (val == '.')
                            continue;
                        if (!box.add(val))
                            return false;
                    }
                }
            }
        }
        return true;
    }
}

/*
    Row must contain 1 - 9, no dupes
    Col 1 - 9, no dupes
    Each subox 1 - 9, no dupes

    IMplemntaion
    For each row usinga set and map out vlaues into set temporarily, then
*/