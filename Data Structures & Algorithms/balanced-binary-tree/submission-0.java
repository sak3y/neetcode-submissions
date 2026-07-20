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
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int diff = Math.abs(height(root.left) - height(root.right));
        if (diff > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int height(TreeNode root) {
        if (root == null) return 0;

        return 1 + Math.max(height(root.left), height(root.right));
    }
}

/*
    INTUITION
    - Is the diffference in height between a left and right subtree greater than 1?
    - Bottom up approach:
        - evalaluate a node at the end and compare the heights of the left and right subtree
        - If over 1, return false.

    Recursion
    - Seperately on the left and right branch
    - Compare values
    - Return accordingly
*/