class Solution:
    def jump(self, nums: List[int]) -> int:
        res = 0
        l, r = 0, 0

        while r < len(nums) - 1:
            end = 0
            for i in range(l, r + 1): # range of the curr val
                end = max(end, i + nums[i])

            l = r + 1
            r = end
            res += 1
        return res
"""
implementing a greedy approach
seperate the array into windows, that represent the range of the jumps we cna make from
a value
using l and r to represent the dimensions of that window, we can they try values within
that window to see what the next window is, at the same time, we know that the number of
windows that we have is our results for getting to the last index
"""