class Solution {
    int ROWS;
    int COLS;
    int[][] dir = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};

    public int maxAreaOfIsland(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;

        int islandSize = 0;
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == 1) {
                    islandSize = Math.max(islandSize, dfs(grid, r, c));
                }
            }
        }
        return islandSize;
    }
    private int dfs(int[][] grid, int r, int c) {
        if (r < 0 || r >= ROWS || c < 0 || c >= COLS || grid[r][c] == 0) return 0;

        grid[r][c] = 0;

        int area = 1;
        for (int[] d : dir) {
            int row = r + d[0];
            int col = c + d[1];

            area += dfs(grid, row, col);
        }
        return area;
    }
}


/*
    Islands exists within the grid; 1s
    is a series of connected ones either hor or vert seperated by water
    GOAL: Biggest island size

    EC: no islands exist, return 1

    IMPLEMENTATION
    - brute force approach
    - start at the first cell.
    - When finding a 1, we perfrom dfs
    - looking all direction for a 1, considering a cell is valid:
        not a 0
        not out of bounds
        not been visited -> convert visited to 0s

    - incrememnt island count

    do that until we finsih the grid
    return our current maximum
*/