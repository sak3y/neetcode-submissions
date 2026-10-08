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
                return 0

            return 1 + max(maxHeight(node.left), maxHeight(node.right))

        if not root:
            return True

        q = [root]

        while q:
            cur = q.pop()

            leftH = maxHeight(cur.left)
            rightH = maxHeight(cur.right)

            if abs(leftH - rightH) > 1:
                return False

            if cur.left:
                q.append(cur.left)
            
            if cur.right:
                q.append(cur.right)


           


        return True



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

    2. Compare heights

"""