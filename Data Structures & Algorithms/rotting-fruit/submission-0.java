class Solution {


    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();

        int fresh = 0;
        int time = 0;

        int[][] dire = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        // Track fresh fruits + initialise q with rotten fruits
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    fresh++;
                }
                if (grid[r][c] == 2) {
                    q.offer(new int[]{r, c});
                }
            }
        }

        // BFS
        while (!q.isEmpty() && fresh > 0) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int[] curr = q.poll(); // our rotten
                int r = curr[0];
                int c = curr[1];

                for (int[] dir : dire) {
                    int row = dir[0] + r;
                    int col = dir[1] + c;

                    // Four way
                    if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == 1) {
                        // convert
                        q.offer(new int[]{row, col});
                        grid[row][col] = 2;
                        fresh--;
                    }
                }
            }
                time++;

        }
        return fresh == 0 ? time : -1;
    }
}
/*
    Idea is that 
    we have a timer
    At every minute, the rotten fruits spread to adjacent fruits

    GOAL: Find the time fro all the fruits to be rotten

    Number of RF >= 1

    In which case, we have to track multiple rotten fruits
    BFS is the idea here since, we they spread out to the closest -> furthers
    It may also be the case that a fruit is isolated and therefore can't be reached/ reach other fruits in whcih case return 0
    Problems:
    - First locate the rotten fruits
    - Perorm bfs simulteanously on all rotten fruits.
    - Check at each time to see if all the fruits are rotten
    - Handle edge cases:
        What if we can't reacha fresh fruit return 0. How do we know that?
    

    Implementaitn
    - Handle edge cases so if we can't find amke a fresh t rotten
    - Traverse every square to find the rotten f
    - Perfrom bfs on those values in sync
    - Check at each stage to see if all fresh are rotten
    

    How do we perfrom bfs in sync?
        I guess we keep an array of all teh rotten tomato values during an inital parse then we loop over those values performing dfs

    How do we keep track of all the fruits and whether they have become rotten?
    Have a count on inital parse, reduce as we convert tomato to rotten, then decrement our count




*/