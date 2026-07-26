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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);

        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                TreeNode top = q.poll();
                
                if (top.left != null) q.add(top.left);
                if (top.right != null) q.add(top.right);

                if (i == len - 1) {
                    res.add(top.val);
                }
            }
        }
        return res;
    }
}


/*

    INTUITION
    - Level order traversal
    - At each level, take the right most node
    - Figure out how to get nodes at each level => bfs
    - 

    IMPLEMNTATION
    - using bfs, we are able to get the nodes that we want in a q
    - startin with root.
    - Root will always be the return value at the first level
    - at each level, in the q we will have all nodes, just pick the last one right?

    [1] [2, 3] [4 5]

    EDGE CASES
    - base case => root == null for children to indicate final level
*/