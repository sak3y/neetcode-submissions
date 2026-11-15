class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        n = len(nums)
        res = []
        nums.sort()
        
        for i in range(n - 3):
            if i > 0 and nums[i] == nums[i - 1]:
                continue

            for j in range(i + 1, n - 2):
                if j > i + 1 and nums[j] == nums[j - 1]:
                    continue

                remaining = target - nums[i] - nums[j]
                l, r = j + 1, n - 1
                
                while l < r:
                    total = nums[l] + nums[r]

                    if total < remaining:
                        l += 1

                    elif total > remaining:
                        r -= 1
                    
                    else:
                        res.append([nums[i], nums[j], nums[l], nums[r]])
                        l += 1
                        r -= 1

                        while l < r and nums[l] == nums[l - 1]:
                            l += 1 

                        while l < r and nums[r] == nums[r + 1]:
                            r -= 1
        return res


"""
    a + b + c + d = target

    a + b = target - c - d.
"""