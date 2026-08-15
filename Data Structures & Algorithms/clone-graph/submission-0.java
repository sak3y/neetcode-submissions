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
    public Node dfs(Node node, Map<Node, Node> map) {
        if (node == null) return null;

          if (map.containsKey(node)) {
            return map.get(node);
        }

        Node copy = new Node(node.val);
        map.put(node, copy);

        for (Node nei : node.neighbors) {
            copy.neighbors.add(dfs(nei, map));
        }

        return copy;
        
    }
}

/*
    GOAL: Create deep copy of the array
    Ajacency list -> a serires of connected nodes as lists
    Index rerpresents that value of the node. So values are between 1 to n where n it the total node number
    Lists start of with a signle node with valu 1 or empty

    Node is empty or 1 return that value
    Since the graph is a double eneded list with values taht are directly connefted at each node
    The node is essentialy the head with pointer to other nodes, 
    Ex. [[2],[1,3],[2]]
    in thsi list, idx 1 is connect to the node with value 2 / idx since idx and val are the same here.
    At 2, we are connect to 1 and 3
    at 3, we are connected to only 2

    Each node can be connect to one or more graphs -> mreans we use recursion
    To build a list, we need the val -> get rom index. and then we need to check whcih nodes connect to whcih exhaustively

    Doubts:
    wouldn't a node be connected to multile nodes like greater than 2 -> yes

    Actual sol:
    Creating a deep copy -> storing + traversal
    Storing => hashmap. Starting at head, we map the node old to old new, so in the example we map 1 to a new node 1.
    2. Check it's neighbours
    3. Go to the neigbour, connect it back
    4. That a two way directional node connection
    5. 
*/