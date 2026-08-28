class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        dupes = set()
        for num in nums:
            if num in dupes:
                return True
            dupes.add(num)

        return False

"""
Find a duplicate.
A set is perffect here. Anytime we add a value.
Ask, is this value already in a set. If it is, then we return false
"""