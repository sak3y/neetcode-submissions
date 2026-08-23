class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEnd;
}

class PrefixTree {
    TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode cur = root;

        for (char c : word.toCharArray()) {
            int i = c - 'a'; // gives index
            if (cur.children[i] == null) cur.children[i] = new TrieNode();
            cur = cur.children[i];
        }
        cur.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode cur = root;

        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (cur.children[i] == null) return false;
            cur = cur.children[i]; 
        }
        return cur.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root;

        for (char c : prefix.toCharArray()) {
            int i = c - 'a';
            if (cur.children[i] == null) return false;
            cur = cur.children[i]; 
        }
        return true;
    }
}


/*
    it's a tree of characters

    insert: 
    - for each char, we add it to an existing branch or make a new one

    search:
    - given a paremeter word, return true if it exists in our prefix tree

    startWith:
    - similar to search but doesn't have to be a word end as long as the characters are 
    there
*/