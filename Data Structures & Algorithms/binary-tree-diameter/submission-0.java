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
    public int diameterOfBinaryTree(TreeNode root) {
        if (root ==  null) return 0;
        
        // Calculate the depth of left + right
        int leftDepth = dfs(root.left);
        int rightDepth = dfs(root.right);
        int diameter = leftDepth + rightDepth;

        // Depth of every node
        int sub = Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right));

        return (Math.max(diameter, sub));


    }

    public int dfs(TreeNode node) {
        if (node == null) return 0;

        return 1 + Math.max(dfs(node.left), dfs(node.right));
    }
}


/*
    The diameter
    - Can go any direction,
    - Includes the edges
    - Cannot go over a node twice

    Essentialy this is a dfs problem
    In the examples, we can go down from 1 - 4.
    We can also go down from 2 - 4 and 2 - 5 => and then combine the solutions.

    How that works in our favour
    - For any given node, find the left depth, right depth. Add the results and store.\
    - Left dfs => recursion
    - Right dfs => recursion
    - Add
    - Store => Workign backwords / recusrively => we return the combined depths at each stage
*/