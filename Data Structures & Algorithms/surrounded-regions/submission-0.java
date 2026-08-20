class Solution {
    int[][] directions = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int ROWS, COLS;

    public void solve(char[][] board) {
        ROWS = board.length;
        COLS = board[0].length;

        bfs(board);

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                }
                if (board[r][c] == 'S') {
                    board[r][c] = 'O';
                }
            }
        }
    }
    private void bfs(char[][] board) {
        Queue<int[]> q = new ArrayDeque<>();
        // Add edge O's
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (r == 0 || r == ROWS - 1 || c == 0 || c == COLS - 1 && board[r][c] == 'O') {
                    q.offer(new int[] {r, c});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int r = cell[0], c = cell[1];
            if (board[r][c] == 'O') {
                board[r][c] = 'S'; // For O cells connect to edge, mark as safe

                for (int dir[] : directions) { // run bfs on adjacent cells that are marked as O
                    int rr = r + dir[0];
                    int cc = c + dir[1];

                    // in bounds
                    if (rr >= 0 && rr < ROWS && cc >= 0 && cc < COLS)
                        q.offer(new int[] {rr, cc}); // add those cells to be later marked as safe
                }
            }
        }
    }
}
/*
    Have a grid of x and o
    O cells from regions if they are connected hor or vert
    Regions can be surrounded x only if none of the O are on the edge of the board

    GOAL: to replace any 'regions' that aren't connected to the edge of the board.
    In the example, there are two regions rightt since a region has to be connected
    By defauly any region connectd ot the edge is safe, and if it isn't we replace it

    Find where the O are, only span O's.
    Determine if that region is safe. i.e, one fo teh O are connected to the edge.
    We then take each of those values thatw e just saw and we place them with an x
    We do that until no invalid regions remain

    Solution
    1. Start at an x,
    2. Do bfs or dfs to determine the dimensions of that region.
    3. Look at whether that region has cells on teh edge
    4. If so, we replace all of those cells with x.
    5. We would need to keep track of visited cells to not repeat our bfs
    6.
*/