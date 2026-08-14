class Solution {
    int ROWS;
    int COLS;
    int islands;
    public int numIslands(char[][] grid) {
        islands = 0;

        ROWS = grid.length;
        COLS = grid[0].length;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == '1') {
                    islands++;
                    dfs(grid, r, c);
                }
            }
        }
        return islands;  
    }

    private void dfs(char[][] grid, int r, int c) {
        if (r < 0 || r >= ROWS || c < 0 || c >= COLS || grid[r][c] == '0') return;

        grid[r][c] = '0';

        dfs(grid, r+1, c);
        dfs(grid, r-1, c);
        dfs(grid, r, c+1);
        dfs(grid, r, c-1);
    }
}

/*
    Find the number of islands
    An island: adjacent 1s connected to each other.

    For each val we can look at adjacent values: left, up, down ,right.
    And we know that an island is just a serires of conencted nodes
    If we then Look at every single adjacent node and then tick them off as visited, meaning we don't go back to them
    Then we can essenitly build hat island and replace it with water to know we've visited it

    Implementation
    Start at a value
    if it's land, mark as visited (replace with 0 ) increment island
    Run dfs on that one values
    Exahsuatively' we'll count all those values as marked '0' and then move on
*/