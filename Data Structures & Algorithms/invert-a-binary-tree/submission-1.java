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
        if (root == null) return null;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}

/* Notes for this

    Recursion has ot be used to exhasust all possible choices.
    It works by calling itself and having a base case where we say if this root is null then end.
    Because i work off the original case we have a shift
*/

/*
    Reversing the tree -> vertical relfection. 

    For each nodes, let work recursively since a left child node, we want to become a right child node and vice vers
    Changing the pointer isn't enough so we need because then we lose referenec to the parent node.

    SO recurisively, the base setup is we have a parent, child l and child r. we swap child l and r. 
    Doing so with a temp node. 
    Move up while parent doesn't exist

    Assume that a parent with a single child get reversed also

    - Route one bottom ot top
    - Go down as far as you can for the deepest tree (DFS)
    - When you cant traverse any more nodes, go up parent and swap. 
    - Evaluate
*/