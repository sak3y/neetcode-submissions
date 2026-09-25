class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        res = 0
        for n in nums:
            res ^= n

        return res

"""
    GOAL: Find hte unique interger in a list

    - We can't store any of the values
    - We can't use more than O(n) tc

    Brute force
    - is two pointer but that wouldn't be valid

    Optimised solution
    - Hint is that we need to use bitwise operations 
    -> don't understand how tho

    The power of XOR:
    we know two numbers share identical bits
    so 6 and 6 would give 0. but more than that, because there are dupes for every number. They all end up becoming 0 except for teh single digit that we bit that's different and htat nnumber just so happens to be the unique number we wantt
"""