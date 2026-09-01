class Solution:
    def isPalindrome(self, s: str) -> bool:
        l = 0
        r = len(s) - 1

        while l < r:
            while l < r and not self.isVal(s[l]):
                l += 1

            while l < r and not self.isVal(s[r]):
                r -= 1
            
            if s[r].lower() != s[l].lower():
                return False;
            
            l += 1
            r -= 1
        
        return True

    def isVal(self, c):
        return ('a' <= c.lower() <= 'z') or ('0' <= c <= '9')
            
