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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int len = q.size();
            List<Integer> level = new ArrayList<>();
            
            for (int i = 0; i < len; i++) {
                TreeNode top = q.poll();
                level.add(top.val);
                if (top.left != null) q.offer(top.left);
                if (top.right != null) q.offer(top.right);
            }
            
            res.add(level);
        }
        return res;
    }
}

/*
    lOT => BFS
    - Implementing a deque
    - At each level, we create a list
    - Add that list to the main list once we reach it's end
    - List size increases in 1, 2, 4, 8 => double the previous value
    

    IMPLEMNTATION
    - push values into a queue starting with root.
    - pop that values, then add it's children in
    - Consecutively add those values into the list
    - using the length of the list we had after adding vlaues in at eahc level. 
    - so that's a whlie loop we have then a for loop that spans the current list. 
    - Pop each then add those values while adding it's children (at some point)
    - 
*/