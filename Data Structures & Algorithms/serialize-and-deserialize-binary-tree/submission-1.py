# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Codec:
    
    # Encodes a tree to a single string.
    def serialize(self, root: Optional[TreeNode]) -> str:
        if not root:
            return ""

        q = deque([root])
        res = []

        while q:
            cur = q.popleft()

            if not cur:
                res.append("n")
                continue
            
            res.append(str(cur.val))

            q.append(cur.left)
            q.append(cur.right)

        return ",".join(res)
        
    # Decodes your encoded data to tree.
    def deserialize(self, data: str) -> Optional[TreeNode]:
        if not data:
            return None

        nodes = data.split(',')
        root = TreeNode(int(nodes[0]))

        q = deque([root])
        i = 1

        while q:
            parent = q.popleft()

            if nodes[i] != "n":
                left = TreeNode(int(nodes[i]))
                parent.left = left
                q.append(left)


            if nodes[i + 1] != "n":
                right = TreeNode(int(nodes[i + 1]))
                parent.right = right
                q.append(right)

            i += 2

        return root


"""
    We're converting the input into string

    Serialize:
    - We can use preorder traversal or bfs to give a string
    Ex: "n2n1345"
    - bfs might easier actually.
    - going store the vlaues and the order is going to represent the structure of the tree
    - return the string -> has all the info to reconstruct the best

    "1,2,3,n,n,4,6" -> bfs repr, comma seperated

    Deserialize:
    - initalise a node -> root with value to set to data[0]
    - the first char is the root
    - Following bfs, we woudl use a queue initalised with root.
    - figure out how to traverse the str so we can construct a 

    Converting str back to a BT
"""