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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (!stack.isEmpty() || curr != null) {
            // go down to the smallest value + add nodes to stack as long as the current node is not null
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            // pop the top of the stack which - at first, gives the smallest value. Store that value and then add the right child
            curr = stack.pop();
            k--;
            if (k == 0) return curr.val;
            curr = curr.right;
        }
        return -1;
    }
}

/*
    Return the Kth smallest integer
    In a BST, the left descendants are always less than the root,
    the rigth descendants are always greater than the root
    the left child is smallesr than the parent nad vice-versa

    to find k we need to 
    - know where the smallest value is
    - navigating up from the smallest to get to k

    we can store each node value in list
    and then order it and find k

    SOLUTION
    - BST => sorted in a sense
    - we need to figure out how to use the tree strucutre to our advantage

    - if we are looking at 4th smallest.
    - we find the smallest, work up the tree by comparing values
    - we know that the smallest value is in the left side of the BST
    - we cna navigate ot that value but we won't know which values that is and
    we don't actually need to know which smallest value that is because we can
    compare our smalles vlaue by going up.
    - the parent of a smallest value is always going to be the next smalles vlaue
    - 
*/