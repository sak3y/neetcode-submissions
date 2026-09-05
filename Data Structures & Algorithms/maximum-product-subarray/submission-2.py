class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        res = max(nums)
        curMin, curMax = 1, 1

        for n in nums:
            if n == 0:
                curMin = 1
                curMax = 1

            tmp = n * curMax
            curMax = max(n, n * curMin, n * curMax)
            curMin = min(n, n * curMin, tmp)
            res = max(res, curMax)
    
        return res
