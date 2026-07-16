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
        if (root == null)  return 0;

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}

/*
    DFS question
    GOAL: REturn the the length of the longest path

    This is another recursion
    - We evaluate left and right, compare values using a var like count - taking the higher val, then we compute

    - How we would evalute max depth w/o recursion
    - We would have a var count
    - Go as far down as long as root isn't null
    - update count as we go along.
    - Return once we get to null.
    - So it's kinda like work backgwords where we only need to have the value of count and not know how we got it.
    - If we get to the base case so: p => l, r: we can return 1 since we have evaluated that we are at the end.
    - If we get to: p => l, r, where either r or l is null, count is still 1.
    - work our way up, we have 1 from that one but another brach for examples of that parent could have returned 5.
    - Take teh larger value.


*/