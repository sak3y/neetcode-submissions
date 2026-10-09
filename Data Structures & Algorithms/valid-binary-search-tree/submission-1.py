# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:

        def dfs(node, lowest, highest):
            if not node:
                return True

            if not (lowest < node.val < highest):
                return False

            return dfs(node.left, lowest, node.val) and dfs(node.right, node.val, highest)


        return dfs(root, -10000000000,10000000000)
"""

    GOAL: Return valid binary seach tree

    Intution:
    - Left child is less than parent
    - Right child is greater
    - Applies for every node

    Example:
    - for a parent of val: 2
    - left child must be 1 or less
    - right child must be 3 or greater

    Brute force:
    - for eahc parent check if child exists and is valid
    - do that for each child (dfs -> bfs also works)

    After review:
    - can't just check immediate children, in a BST, every right child must be greater than the root and all it's ancestors
    - same thing for right 

    Actual solution
    - Since we need to compare left children to the lowest we've seen so far adn not just it's paretn, we pass a paremeter lowest
    - same thing for theh right children -> highest
    - we initailse parent as both teh hgithest and loweest so far
    - tracing this thru: recursing to the left child, we check that it meet codition paretn > l child
    - we then compare against the lowest values seen, if it's true we conitnue
    - the base case is then if a value falls outside the conditon in whcih case we instantly reutrn false
    - otehrwhise we update the parements or 
"""