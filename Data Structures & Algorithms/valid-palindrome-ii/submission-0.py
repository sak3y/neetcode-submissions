class Solution:
    def validPalindrome(self, s: str) -> bool:
        
        def isPalindrome(s: str):
            l, r = 0, len(s) - 1

            while l <= r:
                if s[l] != s[r]:
                    return False
                
                l+=1
                r-=1

            return True
        
        for i in range(len(s)):
            newStr = s[:i] + s[i + 1:]

            if isPalindrome(newStr):
                return True

        return False

# we can choose to remove 1 or 0 chars
# we can run a palindrome chekc which is O(n/2)
# then we can remove each char -> this woulb be O(n)
# so overall: O(n^2)