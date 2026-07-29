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
    public boolean isValidBST(TreeNode root) {
        return isValidNode(root, -1001, 1001);
    }
    private boolean isValidNode(TreeNode node, int min, int max) {
        if (node == null) return true;

        if (node.val <= min || node.val >= max) return false;

        return isValidNode(node.left, min, node.val) && isValidNode(node.right, node.val, max);
    }
}

/*
    A BST => every descendant of the node on the right of a child must be less than that node and every node on the left
    must be less regardless of how far the trees goes down or how many ancestors it is
    
    essentialy to check a tree we need to evaluate on side of the tree and see that it's less thatn the current maximum

    TWO CONDITIONS TO MEET:
    - Every descendant on the left of root is less than the root
    - Every descendant on the right of root is greater than the root
    - Every child on the left of node is less than the node
    - Every child on the right of node is greater than the node

    we only need to keep track of the root values since that won't change and it's the greatest / smallest depening on where
    it's being looked at from
    Keep track of the current node value

*/
