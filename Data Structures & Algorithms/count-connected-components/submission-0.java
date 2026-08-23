class Solution {
    public int countComponents(int n, int[][] edges) {
        // Adj list
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] seen = new boolean[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (!seen[i]) {
                dfs(adj, seen, i);
                res++;
            }
        }
        return res;
    }
    private void dfs(Map<Integer, List<Integer>> adj, boolean[] seen, int i) {
        seen[i] = true;
        for (int e : adj.get(i)) {
            if (!seen[e]) dfs(adj, seen, e);
        }
    }
}

/*
    Similar to islands.
    We have a series of nodes that may form groups.
    A group is a series of connected nodes called edges
    It may be the case that one group is distinct from another in that they have no connecting edges

    Determinining a group:
    - for a given values. We create an adjaceny list
    - Given an adjacency list, we see that no edges connect to 3, 4.
        - For our values in the list, we want to look at every single edge
        - We do that until there are no longer edges we can explore
        - When this happen. We move onto the the next value
    - Wwe form a set
    - Given that there are an n number of nodes, each node rep a val from 0 to n - 1

    Implemntation
    - Adjaceny list first
    - DFS on values in our adj list
    - Add those values to a set
    - If we can longer add values / no more edges to explore -> class as a group
    - Iterate for all values to n - 1
*/
