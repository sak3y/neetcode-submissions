class Solution:
    def numDistinct(self, s: str, t: str) -> int:
        memo = {}

        def dfs(i, j):
            if (i, j) in memo:
                return memo[(i, j)]
            if j == len(t):
                return 1
            if i == len(s):
                return 0
            
            skip = dfs(i + 1, j)

            take = 0
            if s[i] == t[j]:
                take = dfs(i + 1, j + 1)

            memo[(i, j)] = skip + take
            return memo[(i, j)]

        return dfs(0, 0)
"""
    Distinct subsequences:
    s can make up  2**n substrings
    take 'caaat' at each stage, we can choose to include the character
    if we choose to take it then we every choice after that is dependtan on
    selecting thet correctt subs
    
    therefore, we can resuively build all possible subs of s
    Then match all unique instances that equal our string t

    Implementation
    - since wew can build all possible substrings from s
    - we can brute force this using recursion
    - then using dfs, we track subsq that match t
    - retuning the total
    - TC: O(2**n) where n is hte tlenght of the string

    Optimisaions
    - we ccan use memo to avoid recalculating subs we've seen
    - so that turns it into O(n)
"""