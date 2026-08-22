class Solution {
    int[][] dir = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
    boolean[][] seen;
    int ROWS;
    int COLS;

    public int numIslands(char[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;

        seen = new boolean[ROWS][COLS];

        int islands = 0;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == '1' && !seen[r][c]) {
                    dfs(grid, r, c);
                    islands++;
                }
            }
        }
        return islands;
    }

    private void dfs(char[][] grid, int r, int c) {
        if (r < 0 || r >= ROWS || c < 0 || c >= COLS || seen[r][c]  
        || grid[r][c] == '0') return;

        seen[r][c] = true;

        for (int[] d : dir) {
            int row = r + d[0];
            int col = c + d[1];

            dfs(grid, row, col);
        }
    }
}

/*
    An island:
    Series of ones that are next to each other and surrounded by 0's / Water

    GOAL: return the number of islands

    Given a grid of numbers

    INUTION:
    - an islands start at a one and branches out as far as any 1s that are connected
    - This is similar to dfs
    - We check each side and then run dfs. 
    - Once we do that, we can incremetn our island count
    - Convert those 1s to 0 / use an array to keep track of cells we've seen
    - Then search for the next island.
    - This is done for every unit
    - TC: O(n*m)
*/