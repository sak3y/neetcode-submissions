class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        int resLen = 0;
        
        for (int i = 0; i < s.length(); i++) {
            int l = i;
            int r = i;

            // Odd len
            while (l >= 0 && r < s.length() && s.charAt(l) ==
            s.charAt(r)) {
                if ((r - l + 1) > resLen) {
                    res = s.substring(l, r + 1);
                    resLen = r - l + 1;
                }
                l--;
                r++;
            }

            // Even len
            l = i;
            r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) ==
            s.charAt(r)) {
                if ((r - l + 1) > resLen) {
                    res = s.substring(l, r + 1);
                    resLen = r - l + 1;
                }
                l--;
                r++;
            }
        }
        return res;
    }
}

/*
    Palindrome: chars are the same forwards as backwards
    GOAL: to find the longest substring that is a valid palindrome
    In this case, a string can be a substring of itself so
    'abba', the longest would be abba

    BRute force
    - Get every single substring
        we use a slding window technique
        we can use a nestted loop to gives us all possible substring
        that O(n**2)
        - Store each of those values
    - Ask is this a valid palindrome
        - for all our substrings
        - run a helper is thihs a palidnrome which is
    - Pick the longest one, if thtey are hte same len, then any

    Faster Solution
    - Going back to how a paldindrome works -> if we look at for example: "abccba"
    - say we have two pointer in the middle, 
    - going outwards the values match up
    - when we go out of bounds, we find that no chars were correctly mismatched
    - this helps us reduced eht number of substring that we actually need to look at
    - So for each char, in an odd or even lengthed word
    - we start at the middle and expand out, when we reach a state were the chars don't match up, we store what we currently had
    - we do this for the entire word which is O(n) were n is thet length of the word

*/