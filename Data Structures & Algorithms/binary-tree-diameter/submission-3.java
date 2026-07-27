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
    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return diameter;
    }
    private int depth(TreeNode node) {
        if (node == null) return 0;

        int left = depth(node.left);
        int right = depth(node.right);

        diameter = Math.max(diameter, left + right);

        return 1 + Math.max(left, right);
    }
}


/*
    - this is a max length problem in disguise
    - the idea is to pick any path from the root and go down as far as possible
    - keep track of how far u went until u exhaust every possible path
    - for all those lengths, return what was the greatest
    - the root isn't the only thing that holds the longest path.
    - it could be any node so long as a node isnt' gone over twice
    - as such, need to find longest path for each node

    two problems
    - we need to find which node has the longest path
    - need to calculate the length of that path
        - that means combining the max between left and right
    
    SOLUTION
    - Recurisve solution that works on two sides ot a node
    - Get greatest length from right
    - Greatest from left.
    - Return that as a max
    
*/