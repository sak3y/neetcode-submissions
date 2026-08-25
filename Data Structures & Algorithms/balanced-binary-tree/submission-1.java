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
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            if (Math.abs(dfs(temp.left, 0) -  dfs(temp.right, 0)) > 1) return false;

            if (temp.left != null) q.offer(temp.left);
            if (temp.right != null) q.offer(temp.right);
        }
        return true;
    }

    private int dfs(TreeNode node, int height) {
        if (node == null) return 0;

        // get height

        return 1 + Math.max(dfs(node.left, height), dfs(node.right, height));

    }
}

/*
    Is node balanced?
    So for each node, we're looking at whethere the heights are balanced

    balanced: heights differ by no more than 1
    This has ot be true for each node.

    Steps:
    - Find height of a subtree,
    - do that for each node
    - return false if heights difference exceeds 1
    
    Solution
    - because we're looking at the heights of each node, the solution has to be recursive, specifically a dfs solution
    - find the heighs is as simple as a double dfs, were we start at the root
    - get the hieght of hte left subtree
    - hieght of right
    - Compare the values and return false if greatter than 1
    - To do that again, we can go through each node whcih is eiher dfs or bfs
*/
