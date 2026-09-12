class Solution:
    def minDistance(self, word1: str, word2: str) -> int:
        memo = {}

        def dfs(i, j):  
            if i == len(word1):
                return len(word2) - j
            if j == len(word2):
                return len(word1) - i
            if (i, j) in memo:
                return memo[(i, j)]

            if word1[i] == word2[j]:
                return dfs(i + 1, j + 1)

            ins = 1 + dfs(i, j + 1)
            delete = 1 + dfs(i + 1, j)
            update = 1 + dfs(i + 1, j + 1)

            memo[(i, j)] = min(ins, delete, update)
            return memo[(i, j)]

        return dfs(0, 0)

"""
    Three options
    Turn word1 -> word2
    Assume we can get to word2

    Brute force:
    we can use a map
    and then we look at what's missing 

    1. Compare lengths
    if w1 > w2 then we need to remove
    Otherwise we need to add
    if tey are equal then change

    since w2 is the target, we just need to tranform w1
    whcih means getting the frequency fo chars. COmparing it to w2
    then depending on lenghts, we can update the count 
    Issue tho is that order is lost

    Instead a two pointer would need to be applied

    What if we looked at disagreement only and then made a choice
    say we got to a in 'neatcdee', we know it should be an e, so we make a choice:
    do we del, ins or update -> then we know which to do based on the lengths

    ^ Updated

    So we don't actually know the optimal solution in advance.
    So instead of trying to guess, we do all three
    That way it becomes recursive.
    Using pointer, we can then simulate 
    deletion by skipping i, 
    insertion by skipping j
    updating by skipping i and j

    base cases:
    reaching any length of either i or j
"""