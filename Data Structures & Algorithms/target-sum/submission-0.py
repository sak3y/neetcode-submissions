class Solution:
    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        memo = {}

        def dfs(i, total):
            if i == len(nums) and total == target:
                return 1
            if i >= len(nums):
                return 0
            if (i, total) in memo:
                return memo[(i, total)]

            add = dfs(i + 1, total + nums[i])
            subtract = dfs(i + 1, total - nums[i])

            memo[(i, total)] = add + subtract

            return add + subtract

        return dfs(0, 0)

"""
    at any given time we can choose to add or subtracta number
    for any of the decision we can omve to the next numebr since, we those will cover 
    all states
    if our current is less than the target, then we add else subtract
    - subtract when less? -> this won't work since we could have a big value later on that equals reuslts
    our base case hten end up being the lenth or equalling target
    - equalling target -> this doesn't work either since we need to use all the numbers
"""