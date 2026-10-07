class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        memo = {}
        
        def dfs(i) -> bool:
            if i in memo:
                return memo[i]
            if i >= len(s):
                return True
            
            for j in range(i, len(s)):
                substr = s[i:j+1]

                if substr in wordDict:
                    if dfs(j + 1):
                        memo[i] = True
                        return memo[i]
            memo[i] = False
            return memo[i]
        
        return dfs(0)
"""

    GOAL: We wnat ot make the word s
    We can use words from dict as many times as possible or not at all

    Brute force;
    - we cna break down the words but we don't know where the 'space' is
    - a bf solution would evaluates each letter as if there was a spcae there and then check it exists in the dict
    - Ex. we can create a space in: 'n' + 'eetcode' -> neither exists
        'nee' + 'tcode'
        'neet' + 'code' -> both exists

    so for each char we have two choices:
    - we can either include it in our word / skip
    - we can create a word from it / space

    at every space, we check to see if the word exists in dict
    - if it does we can continue
    - otherwise we have to keep adding to that word
    - and the case where we get to the end wiuthout flagging false we return true

    TC: O(2^n)

    Optimised:
    - repeatd calc so using memo specifcally,
    - store 

"""