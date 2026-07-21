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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;

        return (isSameTree(p.left, q.left) &&isSameTree(p.right, q.right));
    }
}

/*
    IDEA
    - We need to compare:
        - Values
        - Structure

    Values
    - Traverse the tree and chekcs values match

    Stucture:
    - Evaluate left and figt simultaneously and check for null

    BRUTE FORCE
    - Looking at the the lowerst node.
    - It point to null => fine
    - Convert into an array list and then compare => O(n + n)
*/