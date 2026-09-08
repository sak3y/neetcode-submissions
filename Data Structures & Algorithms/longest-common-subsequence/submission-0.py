class Solution:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        memo = [[0 for i in range(len(text2) + 1)] for j in range(len(text1) + 1)]

        for r in range(len(text1) - 1, -1, -1):
            for c in range(len(text2) - 1, -1, -1):
                if text1[r] == text2[c]:
                    memo[r][c] = 1 + memo[r+1][c+1]
                else:
                    memo[r][c] = max(memo[r+1][c], memo[r][c+1])

        return memo[0][0]  

"""
    Given 2 strings.
    Find the longest common subsequence between them 
    subqeuence -> matching chars in the same relative order
    if we do look fro a match, comparing the shorter against the longer.
    Going thru each char

    bctcat -> Crabt

    Ex.
    C -> C in 'Crabt'
    a -> a in 'rabt'
    t -> t in 'abt'


    abdef -> defabj

    brute force:
    - take the shorter string
    - go thru each char in short.
    - for this case, we do have to go thru each char in the shorter string even if we do
    end -> is the longer subsequence could be after the initial
    - Check if exists in longer.

    - increment count then move pointer (don't visit again)
    - then take max betwen them 
    ^ above doesn't work

    New Approach
    - we make two subsequences using recursion for all of them fro both string
    - we match each up to see if they are equal
    - get longest val

"""

