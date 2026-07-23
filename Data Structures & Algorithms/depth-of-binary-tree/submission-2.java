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
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}

/*
    DEPTH => longest path down aka height, so that's the number of nodes from parent to bottom child

    BRUTE FORCE
    - Say we go left, go left again, endlessly. At the end we store how far we went
    - do that again but this time each path is taken.
    - Calculate hte max height each time

    recursion
    = For the base case if we are at a value null we can just return whatever teh current depth is
    - what we return is with each recursion a counter.
*/
