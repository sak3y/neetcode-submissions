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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) return true;
        if (root == null) return false;

        if (sameTree(root, subRoot)){
            return true;
        }
        return (isSubtree(root.right, subRoot) ||
            isSubtree(root.left, subRoot));
    }

    private boolean sameTree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if ((root != null && subRoot != null) &&
             root.val == subRoot.val) {
                return (sameTree(root.left, subRoot.left) && sameTree(root.right, subRoot.right));
             }
        return false;
    }
}

/*
    A subtree is a single node of the root and includes all it's descendants.
    That means height and values must be the same. (Pointers instead of height)
    
    BRUTE FORCE
    For each node in root, check to see if the parents of both trees match
    Do that top down untill all descendants match and null values get pointed to


*/
