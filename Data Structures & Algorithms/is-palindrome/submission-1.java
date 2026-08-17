class Solution {
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;

        while (l < r) {
            while (l < r && !Character.isLetterOrDigit(s.charAt(l))) l++;
            while (l < r && !Character.isLetterOrDigit(s.charAt(r))) r--;
            
             if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) return false;

            l++;
            r--;
        }

        return true;
    }
}

/*
    Ispalindrome
    Same forward as backwards, ignoring spaces
    Case insensitive

    SOlutoin
    - Two pointer, initialise at ends of the string
    - Before that, convert to lower case and ignore space.
    - Compare chars until the mid point in which case, wehn l and r becomes equal we return true
    - Return false on any non equal targets
*/