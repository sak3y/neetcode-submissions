class Solution:
    def firstMissingPositive(self, nums: List[int]) -> int:
        numSet = set(nums)

        for i in range(1, len(nums) + 2):
            if i not in numSet:
                return i

            
            


"""
    OUr target num is n, where 1 <= n <= max(nums) + 1

"""