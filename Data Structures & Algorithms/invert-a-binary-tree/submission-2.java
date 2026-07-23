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
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        
        invertTree(root.left);
        invertTree(root.right);
        
        return root;
    }
}
/*
    To flip a binary tree, we flip the left and right children for each node
    take the example

    BRUTE FORCE
    - Start with parent node
    - see that's it's not null
    - check that both children are not null
    - store child right
    - child.left becomes child.right
    - child right becomes child left
    - do that for every single node, 
    - TC: o(n)

    RECURSION
    - EC: both children are null in which case we stop switching
    - store left
    - left beccomes right
    - right becomes left
    - move up
*/