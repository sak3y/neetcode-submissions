class Solution {
    int max;

    public int maxAreaOfIsland(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        max = 0;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == 1) {
                    max = Math.max(max, dfs(grid, r, c));
                }
            }
        }
        return max;
    }

    private int dfs(int[][] grid, int r, int c) {
        int ROWS = grid.length;
        int COLS = grid[0].length;

        if (r < 0 || r >= ROWS || c < 0 || c >= COLS || grid[r][c] == 0) return 0;

        grid[r][c] = 0;

        return 1 + dfs(grid, r+1, c) + dfs(grid, r-1, c) + dfs(grid, r, c+1) + dfs(grid, r, c-1);
    }
}

/*
    Find the biggest islands
    AN islands is made up of 1s, so to find it's area, we simply count the number of adjacents 1s
    We can do that with a dfs algo, that keep a count and every branch updates that count
    Since there could be multiple islands, we have to do a max cmparsion for each of these islands we run dfs on.

    1. Find an island AKA a 1 vales.
    2. Perfrom dfs, replacing each value with 0 as we go along, as we compare adjacent sqaures
    3. update count++
    4. once we have finished counting an island
    5. continue searching for other islands.
    6. Use max comparter to get the biggest island thus far

    Implemntation
    1. Recursion with dfs
    ...

    TC: O(n*m * 4*(i))
*/