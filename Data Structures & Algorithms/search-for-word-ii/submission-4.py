class TrieNode:
    def __init__(self):
        self.children = {}
        self.isEnd = False

    def addWord(self, word):
        cur = self
        for c in word:
            if c not in cur.children:
                cur.children[c] = TrieNode()
            cur = cur.children[c]
        cur.isEnd = True

class Solution:
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        root = TrieNode()
        for word in words:
            root.addWord(word)

        ROWS, COLS = len(board), len(board[0])
        res, visit = set(), set()

        def dfs(r, c, node, word):
            if r < 0 or c < 0 or r >= ROWS or c >= COLS or (r,c) in visit or board[r][c] not in node.children:
                return

            visit.add((r,c))
            node = node.children[board[r][c]]
            word += board[r][c]
            if node.isEnd:
                res.add(word)

            dfs(r + 1, c, node, word)
            dfs(r - 1, c, node, word)
            dfs(r, c + 1, node, word)
            dfs (r, c - 1, node, word)
            visit.remove((r,c))

        for r in range(ROWS):
            for c in range(COLS):
                dfs(r, c, root, "")

        return list(res)


"""
    We can only go horizontal or diagonal.
    When we find a word that exists on the board, we add it res

    Brute force:
    - we pick the first word in our list, 
    match the first char with the chars in the board (for loops)
    - when we get a match, we search recursively the adjacent hor and ver squares
    - we keep track of the visited squares so we don't revisit
    - we add the word to our list, when we reach the len of the word wiht our pointer
    
    The sub problem becomes find word x in the board

    Optimised solution:

"""