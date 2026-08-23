class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        //adj list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= edges.length; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);

            boolean[] visit = new boolean[edges.length + 1];
            if (dfs(edge[0], -1, adj, visit)) return edge;
        }
        return new int[0];
    }
    private boolean dfs(int child, int parent, List<List<Integer>> adj, boolean[] visit) {
        if(visit[child]) return true;

        visit[child] = true;
        for (int c : adj.get(child)) {
            if (c == parent) continue;
            if (dfs(c, child, adj, visit)) return true;
        }
        return false;
    }
}

/*
    Given a connected graph that isn't a cycle with n - 1 edges
    Add a edge in so that it now has a cycle

    We wnat to remove an edge so that:
    - it is not cyclical -> similar to a tree, onec we take a chain, we get a value where we 
    can't visit a new node
    - and all nodes are connected: dfs

    1. Find where the cycle is
    2. decide which edge to remove (any edge is valid)
    

    To find a cycle: 
    - we end up on the same nodes
    - If we keep track of the nodes that we've visited.
    - Using dfs, and end up on the same node, then we reached a cycle. So the edge before that is
    our result
    - the issue is, edges are undirected so we can go between nodes and it is may be considered a 
    cycle
    - if we have a var of last visited and say we can't go that way would fix the problem

    Implementation
    - 
*/