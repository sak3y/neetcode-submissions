/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> copyList = new HashMap<>();

        Node cur = head;
        while (cur != null) {
            Node copy = new Node(cur.val);
            copyList.put(cur, copy);
            cur = cur.next;
        }

        cur = head;

        while (cur != null) {
            Node copy = copyList.get(cur);
            copy.next = copyList.get(cur.next);
            copy.random = copyList.get(cur.random);
            cur = cur.next;
        }
        return copyList.get(head);
    }
}

/*
    Create a DEEP COPY
    => a deepy copy implies that the orignal list and all it's pointer and random pointers are copied
    - but this is done given that we only have the head node and it's next pointers
*/