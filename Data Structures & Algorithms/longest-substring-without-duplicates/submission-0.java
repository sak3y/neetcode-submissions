class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) return s.length();

        Set<Character> window = new HashSet<>();
        int l = 0;
        int res = 0;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);

            while (window.contains(c)) {
                window.remove(s.charAt(l));
                l++;
            }

            window.add(c);
            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}


/*
    Idea
    - want to find the longest substring without dupes
    - that means we need to keep track of substrings
    - don't need to know the chars since output -> int
    - sliding window would look at the values between two pointers, after they
    have been looking at.
    - fastest solution would be looking like hashmap, and then do .containts
     to see if a chars exists
    

    Problem
    - need to figure out how to compare substrings
    = find longest substring => it's a sequence of chars without duplicates


    Solution
    - for each char we see if it exists in the map
    - if not we move the right pointer 
        - curr += 1
    - if it does we move both pointers
        - we then update the curr to 0 
    - continue this until r reaches the end

    Edge cases:
        - shortest is 1 so that's that unless non chars, in which case it's 0
        - since we set r at 1, we need to check the length of s first to avoid null pointer error
*/