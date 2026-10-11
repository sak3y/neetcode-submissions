# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        
        sum = -99999999999
        def dfs(node):
            nonlocal sum

            if not node:
                return 0
            
            left = max(0, dfs(node.left))
            right = max(0, dfs(node.right))

            sum = max(sum, node.val + left + right)

            return node.val + max(left, right)
        
        dfs(root)
        return sum


"""
    A path sum can be as long as we want
    GOAL: Return the longest path sum

    - Some paths are not worth taking
    - Paths don't have to incdlude thhe root

    Brute force:
    - for each node, we can choose to add the value to a running sum
    - or skip
    - when adding, we evaluate the child exists
    - for a right child, we can choose to add or skip
    - for left child, add or skip
    - so 4 options at each node are to:
        - add left and right
        - skip left and right
        - add left, skip right
        - add right, skip left
    - TC: O(4^n)

    Optimisations:
    - bottom-up approach couuld work
    - we can evaluate wheter two nodes gives us a net positve value
    - we consider them and ignore the rest
    - working our way up, we then combines sums at each bottom level
"""