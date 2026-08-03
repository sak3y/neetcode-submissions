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
      

        return (isSameTree(p.right, q.right) && isSameTree(p.left, q.left));
    }
}

/*
    Compare trees to see if they are equal

    A tree is equal if it has the:
    same nodes
    same values 
    in the same place

    The idea is
    Have two pointer that look at each node. Check values
    Then they follow the general structure

    DFS
    - we could use a stack that pushes values in the tree.
    - We pop the value
    - Compare it's equal
    - Then push it's children 
    - Pop
    - Check it's equal
    - End when it's becomes null

    Recursion
    - base case: if the tree is null return true
    - If values are equal

*/