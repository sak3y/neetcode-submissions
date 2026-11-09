class Solution:
    def validPalindrome(self, s: str) -> bool:
        
        def isPalindrome(l, r):
            while l <= r:
                if s[l] != s[r]:
                    return False
                
                l+=1
                r-=1

            return True

        l, r = 0, len(s) - 1
        
        
        while l < r:
            if s[l] != s[r]:
                return isPalindrome(l + 1, r) or isPalindrome(l, r - 1)

            l+=1
            r-=1

        return True

# we can choose to remove 1 or 0 chars
# we can run a palindrome chekc which is O(n/2)
# then we can remove each char -> this woulb be O(n)
# so overall: O(n^2)

# we can find a more efficient choice