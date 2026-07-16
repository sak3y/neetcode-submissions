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
    int res;

    public int diameterOfBinaryTree(TreeNode root) {
        res = 0;
        dfs(root);
        
        return res;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);

        res = Math.max(res, left + right);

        return 1 + Math.max(left, right);
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