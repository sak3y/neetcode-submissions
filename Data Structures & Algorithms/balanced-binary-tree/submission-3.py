# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        # find max height for either side at a node
        def maxHeight(node):
            if not node: 
                return [True, 0]

            leftHeight = maxHeight(node.left)
            rightHeight = maxHeight(node.right)

            isBalanced = abs(leftHeight[1] - rightHeight[1]) <= 1 and leftHeight[0] and rightHeight[0]

            return [isBalanced, 1 + max(leftHeight[1], rightHeight[1])]


            

        return maxHeight(root)[0]
"""
    GOAL: Find out if a BT is balanced
    Left and right heights must be the same OR have a difference of 1 -> to be valid
    To for every node

    Brute force:
    - For each node (start from root)
    - Check the max height of the left subtree and right subtree

    Sub Problem:
    - Find max height of subtree
    - Compare height fo left and right subtree
    - Return false conditionally

    1. Find max height of subtree
        - Dfs: recursively go down both left and right
        - add 1 each time
        - then when we reach a null node, return

    2. Apply the maxHeight to each node
        - Use a queue (bfs)

    TC: O(n) -> for the max height calc and O(m) for each node so O(n^2)

    Optimisations:
    - rather than calculate height for each node
    - in the function, compare height as we go up the tree (recursively)
    - TC: O(n)

"""