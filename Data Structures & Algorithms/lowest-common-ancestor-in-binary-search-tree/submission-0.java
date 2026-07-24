/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode cur = root;

        while (cur != null) {
            if (cur.val > q.val && cur.val > p.val) {
                cur = cur.left;
            }
            else if (cur.val < q.val && cur.val < p.val) {
                cur = cur.right;
            }
            else {
                return cur;
            }
        }
        return root;
    }
}
/*
    Find the LCA => the parents of two nodes such that they are as low as possible.
    4, 8 LCA = 5

    INTUITION
    - At each level above p and q. (start we at the lower node sine an ancesetor can be a
    descendant of itself)
    - Check if there is a node that connect the two
    - if it connects => then on the first instance we take taht as the parent and reutr the node

    FINDING THE NODE
    = pefrom dfs and bfs
    - then do the brute force calc

    key is: BST
    - we can roughly find out where a node is depending on it's relative value to the root or any node
    - if we have a split, sat we have two values split between 5. We know that the LCA must be the root sicne that can only the the lca
    - Going donw


*/