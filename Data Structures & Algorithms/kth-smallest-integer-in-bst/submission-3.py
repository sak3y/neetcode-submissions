# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        res = []
        def inorder(node):
            if not node:
                return
            if len(res) == k:
                return 

            inorder(node.left)
            res.append(node.val)
            inorder(node.right)
        
        inorder(root)
        return res[k - 1]

"""
    Find the kth smallest
    
    Understanding a binary tree
    - we know that the root holds the middel value in a bst
    - the leftt most node is the smallest
    - 1-indexed
    
    Brute force
    - we cna traverse all teh numbers and store them in a list
    - then sort that list and return the kth integer from the end

    Optimised solutions
    - we find a way to traverse the tree such that it goes from, dec to inc order
    - that means starting at the left most node
    - we implement preorder dfs (how?)
    - Tracing: 
        - left child -> parent -> right child
        but then for the left child -> recurse the chain for that one and so on


"""