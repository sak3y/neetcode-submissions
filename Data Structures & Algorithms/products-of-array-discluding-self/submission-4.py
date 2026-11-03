class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        n = len(nums)

        left = [1] * n
        right = [1] * n

        for l in range(1, n):
            left[l] = left[l - 1] * nums[l - 1]

        for r in range(n - 2, -1, -1):
            right[r] = right[r + 1] * nums[r + 1]

        res = []
        for i in range(n):
            res.append(left[i] * right[i])
        
        return res

# we can use a nested loop, TC: O(n^2)
# i guess we could create two array that store the product of all values to the left and ritht
# then when we get toa  number we add left and ritht
        # 0  1  2  3
# nums = [1, 2, 4, 6]
# left = [1, 1, 2, 8]
# right= [48, 24, 6, 1]

# res  = [48, 24, 12, 8]