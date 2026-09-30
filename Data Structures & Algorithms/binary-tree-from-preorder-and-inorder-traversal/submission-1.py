# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if not preorder or not inorder: 
            return None

        index = {val : idx for idx, val in enumerate(inorder)} # map our index : preorder val (partition)
        self.fidx = 0

        def dfs(l, r):
            if l > r:
                return None
            
            rval = preorder[self.fidx]
            self.fidx += 1 # increment our pointer
            root = TreeNode(rval)
            mid = index[rval] # inorder -> split partition l and r
            root.left = dfs(l, mid - 1)
            root.right = dfs(mid + 1, r)
            return root
        
        return dfs(0, len(inorder) - 1)



"""
    preorder -> root -> left -> right
    inorder -> left -> root -> right

    Observations

    preorder = reversse (inorder) up till halfawy
    We know left most node, root and right most node.
    We can use that information to seperate out the values in the elft and right sdie

    Inorder:
    values between left Node and root are all in the left

    Prorder:
    Single path to the left most node and then every child before has a right child

"""