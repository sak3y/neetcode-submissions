class TrieNode {
    TrieNode[] children;
    boolean isEnd;

    public TrieNode() {
        children = new TrieNode[26];
        isEnd = false;
    }

}

class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;

        for (char c : word.toCharArray()) {
            int idx = c - 'a';

            if (cur.children[idx] == null) {
                cur.children[idx] = new TrieNode();
            }
            cur = cur.children[idx];
        }
        cur.isEnd = true;
    }

    public boolean search(String word) {
        return dfs(root, word, 0);
    }

    private boolean dfs(TrieNode cur, String word, int i) {
        if (i >= word.length()) return cur.isEnd;

        char c = word.charAt(i); // Currrent char
        if (c == '.') {
            for (TrieNode child : cur.children) {
                // Parse children to find match
                if (child != null && dfs(child, word, i + 1)) return true; // if we find a match and it's not emtpy, run dfs on that child on the next letter
            }
            return false;
        }

        TrieNode next = cur.children[c - 'a']; // se our new node to be a child of the existing node (moving pointer)
        if (next == null) return false; 

        return dfs(next, word, i + 1); // Essentially run the dfs on the next char until we go out of bounds
    }
}

/*
    Add new word
    Seach exisitng words

    AddWord()
        adds a word to the ds

    search()
        check to see if a word exists in the ds
        '.' represent any char -> we see 27 chars in total inlcuding lower case
        since '.' can represent any character, we have to explore all possible variations
        the brute force option here is to scan each character and greedily check the paths
        starting from a -> z


    
    In this ds, we won't need a flag
    Going to be using trie / prefix tree
    Essentiatyl parse thru each char and chain the character to each other

    For example day
    - Insert 'd' into slot
    - Inser 'a' into slot
    - Insert 'y' into slot

    Handling '.' operation
    Since . represents any of the 26 chars that we have. We have to parsse the entire array.
    That's O(26) => O(1)

    assume . can't be used in the process of making a word
    and also, search must match the string exactly and not partially aka can't be a prefix of word
*/