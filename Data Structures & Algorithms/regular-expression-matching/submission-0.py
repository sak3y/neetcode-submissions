class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        m, n = len(s), len(p)
        memo = {}

        def dfs(i, j):
            if j == n:
                return i == m
            if (i, j) in memo:
                return memo[(i, j)]

            ismatch = i < m and (s[i] == p[j] or p[j] == '.')

            if j + 1 < n and p[j + 1] == '*': # O(2**n)
                memo[(i, j)] = dfs(i, j + 2) or (ismatch and dfs(i + 1, j))  # recursive call        
                return memo[(i, j)]
            
            if ismatch: # o(n)
                memo[(i, j)] = dfs(i + 1, j + 1)
                return memo[(i, j)]

            memo[(i, j)] = False
            return memo[(i, j)]
        
        return dfs(0, 0)


"""
    optimisations:
    memo:
    because we recursivey splt
    we do actually end up repeating calculations 

    2 Rules:
    '*' -> anything just before this, we can repeat as many times as possible or not
    '.' -> represent any char

    .* represent any string
    GOAL: given p, can we turn it into s using the rules

    "aaa.*bb" -> "aaaccbbb"

    Intuition
    . matches wiht anything, so we skip
    * evaluate char before and then incremetn so long as the character hasn't changed
    .* -> this is where things get bit a tricky. We can go as far as we want with this
    since it tracks all possible string. 
    The issue tho is that how do we know when to stop? any character after it still 
    has to match up

    Brute force:
    - we match char for char
    - when we reach a ., we increment
    - when we reach a *, 
    
    Implementation -> solution checked
    - so we only need to perform dfs when we reach a character with a * right after
    - that means check the current and current + 1
    - all other cases we compare char for char
    - for . we can skip
    - for .* we can (edge case) -> 
    - for string starting wiht * -> invalid
    
"""