/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        Map<Node, Node> map = new HashMap<>();

        return dfs(node, map);
    }

    private Node dfs(Node cur, Map<Node, Node> map) {
        if (cur == null) return null;

        if (map.containsKey(cur)) return map.get(cur);

        Node copy = new Node(cur.val);
        map.put(cur, copy);

        for (Node neig : cur.neighbors) {
            copy.neighbors.add(dfs(neig, map));
        }
        return copy;

    }
}

/*

    1 -> 2, 3
    2 -> 1, 4
    3 -> 1, 4
    4 -> 2, 3

    Return a deep copy of the graph
    Deep copy: we need to create nodes and their edges and replicated
    in a new memory slot

    A node has a value and has holds the nearest neighbours
    when we create a deep copy, we care creating a new node, and then for it's neightbours, we create them as well.
    Similar to a tree, we only have to return the starting node.
    and we're also given a node too

    Nodes go from 1 to n, are 1 indexed and represent their index.
    An adjancency list is how our nodes are reprrestented.

    Mapping our nodes to neighbours,
    - We know that creating a node is simple: it's a value but then how do we map it's values.
    - Given an adj list, and then parse those, and crate nodes add those to the given neighobours, 
    - we do that for all vals in adj

    node:
    - Val
    - Neighbours

    Since we only have access to a root node, creatina an adj list isn't viable, instead, we need to perfrom dfs and then add neigbours as we go along, 
    - recursion is neccesary here to exhaust all branches
    - dfs a node root, then it's immediatte child, so given one, 2
*/