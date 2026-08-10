class TrieNode {
    TrieNode[] children;
    boolean wordEnd;

    TrieNode() {
        children = new TrieNode[26];
        wordEnd = false;
    }
}

class PrefixTree {
    TrieNode root;

    public PrefixTree() {
         root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode cur = root;

        for (char c : word.toCharArray()) {
            int idx = c - 'a'; // index of char

            // if char doesn't exist in tree
            if (cur.children[idx] == null) {
                cur.children[idx] = new TrieNode();
            }
            cur = cur.children[idx]; // Go down branch
        }
        cur.wordEnd = true; // At the end of word, turn flag to true
    }

    public boolean search(String word) {
        TrieNode cur = root;

        for (char c : word.toCharArray()) {
            
            int idx = c - 'a'; // index of char

            if (cur.children[idx] != null) {
                cur = cur.children[idx];
            }
            else {
                return false;
            }
        }
        return cur.wordEnd;
    }   

    public boolean startsWith(String prefix) {
        TrieNode cur = root;

        for (char c : prefix.toCharArray()) {
            
            int idx = c - 'a'; // index of char

            if (cur.children[idx] != null) {
                cur = cur.children[idx];
            }
            else return false;
        }
        return true;
    }
}
/*
    insert:
        - inserts a word into the prefix tree
        - Inserting goes char by char
        - we insert a node at each index that represent our char
        - update pointer to next char
        - repeat
        - on last char, update flag to true

    search
        - returns true if the word is in the tree
        - we check char by char
        - see if a node exists
        - we update the pointer by going down branch
        - check again
        - on end, say does the flag match the end?
        - yes -> return true, else false

    startWith
        - matches character, not full string exactly
        - go char by char
        - see if node exist
        - traverse child
        - difference here is that we don't chekc the flag
*/