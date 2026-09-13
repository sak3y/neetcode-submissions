# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        def dfs(node):
            if not node:
                return node
            if not node.left and not node.right:
                return node
            
            temp = node.left
            node.left = node.right
            node.right = temp

            dfs(node.left) 
            dfs(node.right)

            return node

        return dfs(root)
                    


""" invertinting a binary tree

to invert a tree, what happens to each node
- so we see that the left and right child swithc placs. 
- if we work backwards, left = temp, left = right, right = temp
- do that for each node.
- Recursive solution:
    base case:
    a node that doesn't have children
    we end
    ec: only has one child, in which case, we still swap them """