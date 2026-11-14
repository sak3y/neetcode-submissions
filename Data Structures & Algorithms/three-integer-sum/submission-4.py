class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        res = []
        nums.sort()
        n = len(nums)

        for k in range(n):
            if k > 0 and nums[k] == nums[k - 1]:
                continue

            l, r = k + 1, n - 1
            target = -nums[k]
            
            while l < r:
                total = nums[r] + nums[l]

                if total < target:
                    l += 1
                elif total > target:
                    r -= 1
                else:
                    res.append([nums[l], nums[r], nums[k]])
                    l += 1
                    r -= 1

                    while l < r and nums[l] == nums[l - 1]:
                        l += 1

                    while l < r and nums[r] == nums[r + 1]:
                        r -= 1
        return res


"""
    i + j + k = 0
    i + j = -k
"""