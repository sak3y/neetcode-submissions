class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        memo = {}

        def recur(i, prev):
            if i == len(nums):
                return 0
            if (i, prev) in memo:
                return memo[(i, prev)]

            skip = recur(i + 1, prev)

            take = 0
            if prev == -1 or nums[i] > nums[prev]:
                take = 1 + recur(i + 1, i)

            memo[(i, prev)] = max(skip, take)

            return memo[(i, prev)]
            
        return recur(0, -1)

"""
    Longest subsequence 
    - doens't have ot be consecutive
    - [1,2,3,7] is the subseqeunce for [9,1,4,2,3,3,7]
    - maintiain order -> no sorting
    
    GOAL: is to find the longest subseqeuence

    Brute force:
    - well, we start at the first number, l = 1
    - 1 - 4 - 7
    - 1 - 2 - 3 - 7 -> res

    because we can skip elemetns, it's not as simple each checking one chain for a val
    instead we have to check all possible paths where n, n < n + 1, 2...

    How do implement this?
    - we take a val
    - we ask, is the next value greater than curr
    - yes -> then create a recrusive chain
        - we can chose to take the next value or skip
        - this will be done recursively to exhaust all possible paths
    - no -> skip
    ^
    this should cover all chain for a given number
    - loop thru each number
    - comparing the current length to global max => returning
    - base case:
        - if the number is <= curr
            skip the next number
        - or we are out of bounds
    TC: O(2**n)


"""