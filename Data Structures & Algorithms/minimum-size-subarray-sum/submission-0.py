class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        res = float('inf')
        total = 0
        i = 0

        for j in range(len(nums)):
            total += nums[j]

            while total >= target:
                res = min(res, j - i + 1)
                total -= nums[i]
                i += 1
            
        
        return res if res != float('inf') else 0

