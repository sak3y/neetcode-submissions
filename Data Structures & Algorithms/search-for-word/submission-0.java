class Solution {
    boolean [][] visited;
    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (dfs(board, word, r, c, 0))
                    return true;
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, String word, int r, int c, int idx) {
        if (idx == word.length())
            return true;

        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length
            || word.charAt(idx) != board[r][c] || visited[r][c]) {
            return false;
        }

        visited[r][c] = true;
        // Check neighbours
        boolean res = dfs(board, word, r + 1, c, idx + 1) || dfs(board, word, r - 1, c, idx + 1)
            || dfs(board, word, r, c + 1, idx + 1) || dfs(board, word, r, c - 1, idx + 1);
        visited[r][c] = false;

        return res;
    }
}

/*
    Board + word
    Find word in board
    For a word to exist:
        - It must connect either horizontally or vertically with a square
        - cannot re use the same cell
        - Keep track of moves

    brute force
    - for each element. We checks, does the character match with the first letter in word
    - if it does
        - Does it connect on any of the adjacent sides of a square
        - it it does, move to that value and check the sides again, ignoring the side we came from

    - If it doesn't,
        Move to the next character
    TC: Thru each element, then check 4 sides max for eahc char O(n * 4*n)

    Implemnetaiotn
    - [1,1] => check: [1,0], [1,2], [0,1], [2, 1]
*/