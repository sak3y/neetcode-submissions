class Solution {
    List<List<String>> res;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();

        backtrack(s, 0, new ArrayList<>());
        return res;
    }

    private void backtrack(String s, int i, List<String> cur) {
        if (s.length() <= i) {
            res.add(new ArrayList<>(cur));
            return;
        }
        // For each partition, run pali check
        for (int j = i; j < s.length(); j++) {
            if (isPalindrome(s, i, j)) {
                cur.add(s.substring(i, j + 1)); // on valid pali, add to res
                backtrack(s, j + 1, cur);
                cur.remove(cur.size() - 1);
            }
        
        }

    }

    private boolean isPalindrome(String word, int l, int r) {
        while (l < r) {
            if (word.charAt(l) != word.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}

/*
    TWO PROBLEMS
    - Find all substrings
    - Is palindrome

    To finda substring, we can use a binary tree
    that takes in each char.
    Using an index we pasrse each char and make an array, a version that has that char and a version that doesn't
    we do that each time O(2**n) times recursively to cover each case
    Will have duplicates but that's fine

    Palindrome
    - a palindrome is the same read forwared as backwards (symmetrical)
    - This part isn't hard

    Combining the two
    - we know that we can add a value to our list if its' a palindrome.
    - So at the stage where we create a substring OR when we construct all the substrings


*/