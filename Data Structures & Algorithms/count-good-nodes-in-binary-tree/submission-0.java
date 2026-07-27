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
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }
    private int dfs(TreeNode root, int max) {
        if (root == null) return 0;

        int res = (root.val >= max) ? 1 : 0;

        max = Math.max(max, root.val);
        res += dfs(root.left, max);
        res += dfs(root.right, max);

        return res;
    }
}

/*
    IDEA:
    - Looking for the greatest node from a -z 
    - we consider theh root to be a 'good' node since it's in it's
    own path and therefore is the greatest
    - Going down, the node val must be greater than every node in
    it's path to be considered the greatest
    - Return the number of nodes that are 'good'

    IMPLEMNTATION
    - DFS
    - For any given path, DFS must be applied
    - Current greatest must also be tracked

    Ex:
    - 
*/
