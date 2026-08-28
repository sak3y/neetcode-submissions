class Solution {
    public int countSubstrings(String s) {
        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            // Odd length
            int l = i;
            int r = i;

            while (l >= 0 && r < s.length() && s.charAt(l) ==
            s.charAt(r)) {
                res++;
                l--;
                r++;
            }

            l = i;
            r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) ==
            s.charAt(r)) {
                res++;
                l--;
                r++;
            }
        }
        return res;
    }
}

/*
    Given all substrings
    Return the number of substrings that are palindromes
    
    - Each char is a palindrome
    - Uniqeu substring don't matter
    - Consider odd and even len palindromes

    Brute force solution
    - gettin all possible substrings
    - Running the is palindrome checker on each one
    - Keep a count of them
    - Return teh count
    - TC: O(n**2) for all substrings + the check =. O(n**2)
        -> O(N**3)
    
    Two pointer solution from before
    - Since we know a palindrome is the same if we start from a center and go outwards, 
    - use this to check a valid palindrome, and expand to caputre
    all other palindromes
    - 
*/