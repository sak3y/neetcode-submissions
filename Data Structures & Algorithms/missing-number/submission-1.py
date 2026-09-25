class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        for i in range(len(nums) + 1):
            if i in nums:
                continue
            return i
        pass

"""
    So the obvious answer is to sort and then evaluate the next nnumber from 0 to see if it's 1 greater
    tc: O(nlogn)


"""