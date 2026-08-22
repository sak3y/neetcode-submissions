class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length > n - 1) return false;

        // Adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        Set<Integer> seen = new HashSet<>();
        if (!dfs(0, -1, adj, seen)) return false;

        return n == seen.size();
    }

    private boolean dfs(int child, int parent, List<List<Integer>> adj, Set<Integer> seen) {
        if (seen.contains(child)) return false;

        seen.add(child);
        for (int n : adj.get(child)) {
            if (n == parent) continue;

            if (!dfs(n, child, adj, seen)) return false;
        }

        return true;
    }
}

/*
    What makes a tree:
    - Connected
    - No cycle / loops

    We know a graph is connected if we can traverse the entire graph from the root so 
    having a var visited and then seeing if it matches n

    Cycle wil show up if we have a set and then when we add values via dfs, the value
     has shown up already
    


*/