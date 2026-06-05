class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map1.put(s.charAt(i), map1.getOrDefault(s.charAt(i), 0) + 1);
            map2.put(t.charAt(i), map2.getOrDefault(t.charAt(i), 0) + 1);
        }
        
        return (map1.equals(map2));
    }
}


/*
    Solution:
    - Keep count of each char (use a map or table)
    - Go thru each char one by one adding them to a map.
    - If we see that a char appears more than once, update count,
        else add to map
    - If one char doesn't appear in the other then instant false
    - Demoing Ex1. r -> 2, a -> 2, c -> 2, e -> 1

    Edge cases:
    - Lengths must be equal
*/